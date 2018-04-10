USE [EAS]
GO

DECLARE @maxProductId float, @productKey integer  
SET @maxProductId = 0  
SET @productKey = 424
WHILE (@maxProductId ) < 10000
BEGIN 
	INSERT INTO [dbo].[Productos] ([CiudadDestinoId],[CiudadOrigenId],[EspectaculoId],[LodgingId],[ProductoArrivalDate],[ProductoCodigo],[ProductoDepartureDate],[ProductoDescripcion],[ProductoImagen],[ProductoNombre],[TransporteId]) 
	VALUES
           ((SELECT TOP 1 [CiudadId] FROM Ciudades ORDER BY NEWID()),
              (SELECT TOP 1 [CiudadId] FROM Ciudades ORDER BY NEWID()),
            (SELECT TOP 1 [EspectaculoId] FROM Espectaculos ORDER BY NEWID()),
           (SELECT TOP 1 [LodgingId] FROM Lodgings ORDER BY NEWID()),
           GETDATE(),
           'Code',
           GETDATE(),
           'Producto Descripcion ' + dbo.udf_Num_ToWords (@maxProductId),
           (SELECT TOP 1 trim(str([column1])+'.'+[column2]) FROM [EAS].[dbo].[images] ORDER BY NEWID()),
           'Producto Nombre ' + dbo.udf_Num_ToWords (@maxProductId),
           (SELECT TOP 1 [TransporteId] FROM Transportes ORDER BY NEWID()))
	SET @maxProductId = @maxProductId + 1 
END
GO
--truncate table [dbo].[Productos]