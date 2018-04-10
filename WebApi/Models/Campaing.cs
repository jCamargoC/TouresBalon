using System.Collections.Generic;

namespace WebApi.Models
{
    public class Campaing
    {
        public int CampaingId { get; set; }
        public string CampaingNombre { get; set; }
        public string CampaingDescripcion { get; set; }
        public string CampaingImagen { get; set; }
        public bool CampaingActivo { get; set; }
        public List<Producto> CampaingProductos { get; set; }
    }
}