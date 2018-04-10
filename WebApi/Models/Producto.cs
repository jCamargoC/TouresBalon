using System;
using System.ComponentModel.DataAnnotations.Schema;

namespace WebApi.Models
{
    public class Producto : Link
    {
        public int ProductoId { get; set; }
        public string ProductoCodigo { get; set; }
        public string ProductoNombre { get; set; }
        public string ProductoDescripcion { get; set; }
        public string ProductoImagen { get; set; }
        public Espectaculo Espectaculo { get; set; }
        public int EspectaculoId { get; set; }
        // public Ciudad Ciudad { get; set; }
        // public int CiudadId { get; set; }
        public Lodging Lodging { get; set; }
        public int LodgingId { get; set; }
        public Transporte Transporte { get; set; }
        public int TransporteId { get; set; }
        public DateTime ProductoArrivalDate { get; set; }
        public DateTime ProductoDepartureDate { get; set; }
        public Ciudad CiudadOrigen { get; set; }
        public int CiudadOrigenId { get; set; }
        public Ciudad CiudadDestino { get; set; }
        public int CiudadDestinoId { get; set; }


    }
}