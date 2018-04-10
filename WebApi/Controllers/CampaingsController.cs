using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using WebApi.Persistence;

namespace WebApi.Controllers
{
    [Route("api/[controller]")]
    public class CampaingsController : Controller
    {
        private IRepository _Repository;

        public CampaingsController(IRepository PorcionRepository)
        {
            _Repository = PorcionRepository;
        }

        public IActionResult GetCampaings()
        {
            var campaings = _Repository.GetCampaings();
            return new JsonResult(campaings);
        }
    }
}