using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.IO;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using WebApi.Models;
using WebApi.Persistence;

namespace WebApi.Controllers
{
    [Route("api/[controller]")]
    public class ProductosController : Controller
    {
        private IRepository _Repository;

        public ProductosController(IRepository PorcionRepository)
        {
            _Repository = PorcionRepository;
        }
        [HttpGet("{id:int}", Name = "GetProduct")]
        public IActionResult ProductById([Required]int id, [FromQuery]string nombre,
        [FromQuery]string descripcion, int pageIndex, int pageSize)
        {
            if (pageIndex == 0) pageIndex = 1;
            if (pageSize == 0 || pageSize > 50) pageSize = 50;
            if (id > 0)
            {
                var producto = _Repository.GetProductById(id);
                producto.Href = Url.Link("GetProduct", new { id = producto.ProductoId });
                return new JsonResult(producto);
            }
            if (!string.IsNullOrWhiteSpace(descripcion) && !string.IsNullOrWhiteSpace(nombre))
            {
                var result = _Repository.GetProductByDescriptionAndName(descripcion, nombre, pageIndex, pageSize);
                fillLink(result.resultSet);
                return new JsonResult(result);
            }
            if (!string.IsNullOrWhiteSpace(nombre))
            {
                var result = _Repository.GetProductByName(nombre, pageIndex, pageSize);
                fillLink(result.resultSet);
                return new JsonResult(result);
            }
            if (!string.IsNullOrWhiteSpace(descripcion))
            {
                var result = _Repository.GetProductByDescription(descripcion, pageIndex, pageSize);
                fillLink(result.resultSet);
                return new JsonResult(result);
            }
            return new NotFoundResult();
        }

        [HttpPost]
        public async Task<IActionResult> CreateProduct(Producto producto, IFormFile file)
        {

            if (file != null)
            {
                var path = Path.Combine(
                                    Directory.GetCurrentDirectory(), "productImages",
                                    DateTime.Now.ToFileTimeUtc() + file.FileName);

                using (var stream = new FileStream(path, FileMode.Create))
                {
                    await file.CopyToAsync(stream);
                }
                producto.ProductoImagen = DateTime.Now.ToFileTimeUtc() + file.FileName;
            }

            _Repository.SaveProduct(producto);
            _Repository.SaveChanges();

            _Repository.fillProduct(producto);
            producto.Href = Url.Link("GetProduct", new { id = producto.ProductoId });
            return new JsonResult(producto);
        }
        internal IEnumerable<Producto> fillLink(IEnumerable<Producto> productos)
        {
            foreach (var producto in productos)
            {
                producto.Href = Url.Link("GetProduct", new { id = producto.ProductoId });
            }
            return productos;
        }
        public IActionResult GetProducts([Required]int pageIndex, [Required]int pageSize)
        {
            if (pageIndex == 0) pageIndex = 1;
            if (pageSize == 0 || pageSize > 50) pageSize = 50;

            var result = _Repository.GetProductos(pageIndex, pageSize);
            fillLink(result.resultSet);
            return new JsonResult(result);
        }

        [HttpGet("[action]")]
        public IActionResult GetTopProducts()
        {
            var productos = fillLink(_Repository.GetTopProductos());
            return new JsonResult(productos);
        }
    }
}