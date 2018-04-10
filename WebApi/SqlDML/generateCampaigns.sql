
USE [EAS]
GO

DECLARE @maxProductId float, @productKey integer  
SET @maxProductId = 0  
SET @productKey = 424
WHILE (@maxProductId ) < 10000
BEGIN
INSERT INTO [Campaigns] ([CampaingActivo],[CampaingDescripcion],[CampaingImagen],[CampaingNombre])
     VALUES
           (0,
           'Descripción de Campaign '+ dbo.udf_Num_ToWords (@maxProductId),
           (SELECT TOP 1 trim(str([column1])+'.'+[column2]) FROM [EAS].[dbo].[images] ORDER BY NEWID()),
           'Nombre de Campaign '+ dbo.udf_Num_ToWords (@maxProductId))

	SET @maxProductId = @maxProductId + 1 
END
GO
--truncate table [dbo].[Campaigns]