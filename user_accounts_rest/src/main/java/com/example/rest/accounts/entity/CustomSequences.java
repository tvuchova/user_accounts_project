package com.example.rest.accounts.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customSequences")
public class CustomSequences {
  @Id
  private String id;
  private Long seq;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getSeq() {
    return seq;
  }

  public void setSeq(Long seq) {
    this.seq = seq;
  }

}
