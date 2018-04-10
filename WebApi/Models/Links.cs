using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;

namespace WebApi.Models
{
    public class Link
    {
        [NotMapped]
        public string Href { get; set; }
      
        //[NotMapped]
        // public string Rel { get; set; }
        // [NotMapped]
        // public string method { get; set; }
    }

    // public class LinkHelper<T> where T : class
    // {
    //     public T Value { get; set; }
    //     public List<Link> Links { get; set; }

    //     public LinkHelper()
    //     {
    //         Links = new List<Link>();
    //     }

    //     public LinkHelper(T item) : base()
    //     {
    //         Value = item;
    //         Links = new List<Link>();
    //     }
    // }
}