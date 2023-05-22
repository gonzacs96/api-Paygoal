package com.apipaygoal.model.response;

import java.util.Date;
import java.util.List;

public class ErrorMessageValidationResponseModel extends ErrorMessageResponseModel {
  List<String> errors;

  public ErrorMessageValidationResponseModel(Date timestamp, String message, List<String> errors) {
    super(timestamp, message);
    this.errors = errors;
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }
}
