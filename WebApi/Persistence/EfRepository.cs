using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Web;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc.Routing;
using Microsoft.EntityFrameworkCore;
using WebApi.DTO;
using WebApi.Models;

namespace WebApi.Persistence
{
    public class EfRepository : IRepository
    {
        private readonly EFDbContext _context;
        public EfRepository(EFDbContext context)
        {
            this._context = context;
        }

        public IEnumerable<Espectaculo> GetEspectaculos()
        {
            return this._context.Espectaculos;
        }

        public Producto GetProductById(int id)
        {
            var product = this._context.Productos.Where(p => p.ProductoId == id).FirstOrDefault();
            fillProduct(product);
            return product;
        }


        public IEnumerable<Producto> GetTopProductos()
        {
            var productList = this._context.Productos
                   .FromSql("Execute GetTopProductos")
                   .ToList();

            foreach (var producto in productList)
            {
                fillProduct(producto);
            }
            return productList;
        }

        public IEnumerableResult<Producto> GetProductos(int pageIndex, int pageSize)
        {
            var productList = this._context.Productos.OrderBy(p => p.ProductoId).Skip((pageIndex - 1) * pageSize).Take(pageSize);

            var total = this._context.Productos.Count();
            
            foreach (var producto in productList)
            {
                fillProduct(producto);
            }

            var result = new IEnumerableResult<Producto>();
            result.resultSet = productList.ToList();
            result.totalLength = total;
            return result;
        }

        public void fillProduct(Producto producto)
        {
            producto.Lodging = this._context.Lodgings.Where(l => l.LodgingId == producto.LodgingId).FirstOrDefault();
            producto.Transporte = this._context.Transportes.Where(l => l.TransporteId == producto.TransporteId).FirstOrDefault();
            producto.Espectaculo = this._context.Espectaculos.Where(l => l.EspectaculoId == producto.EspectaculoId).FirstOrDefault();
            producto.CiudadDestino = this._context.Ciudades.Where(l => l.CiudadId == producto.CiudadDestinoId).FirstOrDefault();
            producto.CiudadOrigen = this._context.Ciudades.Where(l => l.CiudadId == producto.CiudadOrigenId).FirstOrDefault();
            producto.CiudadDestino.Pais = this._context.Paises.Where(c => c.PaisId == producto.CiudadDestino.PaisId).FirstOrDefault();
            producto.CiudadOrigen.Pais = this._context.Paises.Where(c => c.PaisId == producto.CiudadOrigen.PaisId).FirstOrDefault();
            producto.ProductoImagen = getImage(producto.ProductoImagen);

        }

        internal string getImage(string filename)
        {
            if (filename == null)
                return "filename not present";

            var path = Path.Combine(
                           Directory.GetCurrentDirectory(),
                           "productImages", filename);
            byte[] b = System.IO.File.ReadAllBytes(path);
            return Convert.ToBase64String(b);
        }
        public void SaveChanges()
        {
            this._context.SaveChanges();
        }

        public void SaveProduct(Producto producto)
        {
            this._context.Productos.Add(producto);
        }

        public IEnumerable<Campaing> GetCampaings()
        {
            var campaigns = this._context.Campaigns.Where(c => c.CampaingActivo == true).Include("CampaingProductos");
            foreach (var campaign in campaigns)
            {
                campaign.CampaingImagen = getImage(campaign.CampaingImagen);
                foreach (var product in campaign.CampaingProductos)
                {
                    fillProduct(product);
                }
            }
            return campaigns;
        }
        public IEnumerableResult<Producto> GetProductByName(string name, int pageIndex, int pageSize)
        {
            var productList = this._context.Productos.Where(p => p.ProductoNombre.Contains(name))
            .OrderBy(d => d.ProductoId)
            .Skip((pageIndex - 1) * pageSize)
            .Take(pageSize);

            var total = this._context.Productos.Where(p => p.ProductoNombre.Contains(name)).Count();

            foreach (var producto in productList)
            {
                fillProduct(producto);
            }
            var result = new IEnumerableResult<Producto>();
            result.resultSet = productList.ToList();
            result.totalLength = total;
            return result;
        }

        public IEnumerableResult<Producto> GetProductByDescription(string description, int pageIndex, int pageSize)
        {
            var productList = this._context.Productos.Where(p => p.ProductoDescripcion.Contains(description))
            .OrderBy(d => d.ProductoId)
            .Skip((pageIndex - 1) * pageSize)
            .Take(pageSize);

            var total = this._context.Productos.Where(p => p.ProductoDescripcion.Contains(description)).Count();

            foreach (var producto in productList)
            {
                fillProduct(producto);
            }

            var result = new IEnumerableResult<Producto>();
            result.resultSet = productList.ToList();
            result.totalLength = total;
            return result;
        }
        public IEnumerableResult<Producto> GetProductByDescriptionAndName(string descripcion, string nombre, int pageIndex, int pageSize)
        {
            var productList = this._context.Productos.Where(p => p.ProductoNombre.Contains(nombre) && p.ProductoDescripcion.Contains(descripcion))
            .OrderBy(d => d.ProductoId)
            .Skip((pageIndex - 1) * pageSize)
            .Take(pageSize);
            var total = this._context.Productos.Where(p => p.ProductoNombre.Contains(nombre) && p.ProductoDescripcion.Contains(descripcion)).Count();
            foreach (var producto in productList)
            {
                fillProduct(producto);
            }
            var result = new IEnumerableResult<Producto>();
            result.resultSet = productList.ToList();
            result.totalLength = total;
            return result;
        }
    }
}