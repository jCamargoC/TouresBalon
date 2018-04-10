
    USE EAS  
    GO  
      
    SET ANSI_NULLS ON  
    GO  
      
    SET QUOTED_IDENTIFIER ON  
    GO  
      
      
    CREATE Procedure [dbo].[GetProductos]  
    (  
     @PageIndex INT,  
     @pageSize INT   
    )   
    As  
     Begin  
     SELECT * FROM Productos ORDER BY [ProductoId] OFFSET @PageSize*(@PageIndex-1) ROWS FETCH NEXT @PageSize ROWS ONLY;  
      
     SELECT count(*) as totalCount FROM Productos;  
     End  
    GO   
