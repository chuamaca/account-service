package com.bootcamp.account.Model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accounts")  
public class Account {  

  @Id
  private String id;
  private String numberAccount; 
  private String type;
  private String documentNumber;
  
}
