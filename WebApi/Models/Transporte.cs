namespace WebApi.Models
{
    public class Transporte
    {
        public int TransporteId { get; set; }
        public string TransporteNombre { get; set; }
        public string TransporteDescripcion { get; set; }
        public decimal TransporteCosto {get;set;}
    }
}