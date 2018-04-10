namespace WebApi.Models
{
    public class Espectaculo
    {
        public int EspectaculoId { get; set; }
        public string EspectaculoNombre { get; set; }
        public string EspectaculoDescripcion { get; set; }
        public decimal EspectaculoCosto {get;set;}
    }
}