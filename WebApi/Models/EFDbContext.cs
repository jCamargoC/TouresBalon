using Microsoft.EntityFrameworkCore;
using System.Linq;
namespace WebApi.Models
{
    public class EFDbContext : DbContext
    {
        public EFDbContext(DbContextOptions<EFDbContext> options) : base(options)
        {
        }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // modelBuilder.Entity<Producto>()
            // .HasOne<Ciudad>(p => p.Ciudad)
            // .WithMany()
            // .HasForeignKey(c => c.CiudadId)
            // .OnDelete(DeleteBehavior.Restrict);
            modelBuilder.Entity<Producto>()
            .HasOne<Ciudad>(p => p.CiudadOrigen)
            .WithMany()
            .HasForeignKey(c => c.CiudadOrigenId)
            .OnDelete(DeleteBehavior.Restrict);
            modelBuilder.Entity<Producto>()
            .HasOne<Ciudad>(p => p.CiudadDestino)
            .WithMany()
            .HasForeignKey(c => c.CiudadDestinoId)
            .OnDelete(DeleteBehavior.Restrict);
        }
        public DbSet<Producto> Productos { get; set; }
        public DbSet<Espectaculo> Espectaculos { get; set; }
        public DbSet<Lodging> Lodgings { get; set; }
        public DbSet<Transporte> Transportes { get; set; }
        public DbSet<Ciudad> Ciudades { get; set; }
        public DbSet<Pais> Paises { get; set; }
        public DbSet<Campaing> Campaigns { get; set; }

    }
}