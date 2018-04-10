using System.Collections.Generic;

namespace WebApi.DTO
{

    public class IEnumerableResult<T>
    {
        public int totalLength;
        //int page;
        //int records;
        public List<T> resultSet;
    }
}