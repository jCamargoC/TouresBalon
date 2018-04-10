using System.Collections.Generic;
using WebApi.DTO;
using WebApi.Models;

namespace WebApi.Persistence
{
    public interface IRepository
    {
        IEnumerable<Espectaculo>  GetEspectaculos();
        IEnumerableResult<Producto> GetProductos(int pageIndex, int pageSize);
        Producto GetProductById(int id);
        IEnumerableResult<Producto> GetProductByName(string name,int pageIndex, int pageSize);
        IEnumerableResult<Producto> GetProductByDescription(string description,int pageIndex, int pageSize);
        void fillProduct(Producto producto);
        void SaveChanges();
        void SaveProduct(Producto producto);
        IEnumerable<Campaing> GetCampaings();
        IEnumerable<Producto> GetTopProductos();
        IEnumerableResult<Producto> GetProductByDescriptionAndName(string descripcion, string nombre, int pageIndex, int pageSize);
    }
}