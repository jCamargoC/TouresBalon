using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using WebApi.Persistence;

namespace WebApi.Controllers
{
    [Route("api/[controller]")]
    public class EspectaculosController : Controller
    {
        private IRepository _Repository;

        public EspectaculosController(IRepository PorcionRepository)
        {
            _Repository = PorcionRepository;
        }

        public IActionResult GetEspectaculos(int? GrupoId)
        {
            var productos = _Repository.GetEspectaculos();
            return new JsonResult(productos);
        }
    }
}