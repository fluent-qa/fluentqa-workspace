package io.fluentqa.postman.model;


public enum ResponseBodyMode {

    URL_ENCODED("urlencoded"),
    FILE("file"),
    RAW("raw"),
    FORM_DATA("formdata"),
    EMPTY("empty");

    private String mode;

     ResponseBodyMode(String mode) {
        this.mode = mode;
    }

    public String getMode(){
        return this.mode;
    }

    public static ResponseBodyMode from(String mode){
      for (ResponseBodyMode value : ResponseBodyMode.values()) {

         if(value.mode.equalsIgnoreCase(mode)){
           return value;
         }
      }
      throw new IllegalArgumentException("%s is not a valid mode".formatted(mode));
    }
}