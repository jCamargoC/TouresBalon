namespace WebApi.Models
{
    public class Ciudad
    {
         public int CiudadId { get; set; }
         public string CiudadCodigo {get;set;}
         public string CiudadNombre { get; set; }
         public int PaisId {get;set;}
         public Pais Pais {get;set;}
    }
}