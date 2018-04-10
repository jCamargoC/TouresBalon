package com.touresbalon.common;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommonResponse {
	 @JsonFormat
     (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
   private Date messageGenerationTime;
   private Object payload;
   
   public CommonResponse(Object o)
   {
       this.messageGenerationTime = new Date();
       this.payload = o;
   }
   
   
   
   public Date getMessageGenerationTime()
   {
       return this.messageGenerationTime;
   }

   public Object getPayload() {
       return payload;
   }

   public void setPayload(Object payload) {
       this.payload = payload;
   }
}
