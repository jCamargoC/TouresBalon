using System.IO;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Design;
using Microsoft.Extensions.Configuration;
using WebApi.Models;

public class DesignTimeDbContextFactory : IDesignTimeDbContextFactory<EFDbContext>
{
    
    EFDbContext IDesignTimeDbContextFactory<EFDbContext>.CreateDbContext(string[] args)
    {
       IConfigurationRoot configuration = new ConfigurationBuilder()
            .SetBasePath(Directory.GetCurrentDirectory())
            .AddJsonFile("appsettings.json")
            .Build();
        var builder = new DbContextOptionsBuilder<EFDbContext>();
        var connectionString = configuration.GetConnectionString("EASDatabase");
        builder.UseSqlServer(connectionString);
        return new EFDbContext(builder.Options);
    }
}