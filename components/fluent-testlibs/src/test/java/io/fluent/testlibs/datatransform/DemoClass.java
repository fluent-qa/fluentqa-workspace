package io.fluent.testlibs.datatransform;

import com.github.mfatihercik.dsb.DSM;
import com.github.mfatihercik.dsb.DSMBuilder;

public class DemoClass {

  public static void main(String[] args) {
    String jsonStr =
        "{\n"
            + "    \"id\": 1,\n"
            + "    \"name\": \"Van Kedisi\",\n"
            + "    \"status\": \"sold\",\n"
            + "    \"createDate\": \"01/24/2019\",\n"
            + "    \"category\": {\"id\": 1,\"name\": \"Cats\"},\n"
            + "    \"tags\": [\n"
            + "        {\"id\": 1,\"name\": \"Cute\"},\n"
            + "        {\"id\": 2,\"name\": \"Popular\"}\n"
            + "    ],\n"
            + "    \"photoUrls\": [\"url1\",\"url2\" ]\n"
            + "}";
    String xmlStr =
        "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
            + "\n"
            + "<Pet id=\"1\">\n"
            + "    <name>Van Kedisi</name>\n"
            + "    <status>sold</status>\n"
            + "    <createDate>01/24/2019</createDate>\n"
            + "    <category>\n"
            + "        <id>1</id>\n"
            + "        <name>Cats</name>\n"
            + "    </category>\n"
            + "    <tags>\n"
            + "        <tag>\n"
            + "            <id>1</id>\n"
            + "            <name>Cute</name>\n"
            + "        </tag>\n"
            + "        <tag>\n"
            + "            <id>2</id>\n"
            + "            <name>Popular</name>\n"
            + "        </tag>\n"
            + "    </tags>\n"
            + "    <photoUrls>\n"
            + "        <photoUrl>url1</photoUrl>\n"
            + "        <photoUrl>url2</photoUrl>\n"
            + "     </photoUrls>\n"
            + "</Pet>";
    DSMBuilder builder = new DSMBuilder("dsm.config.yaml");
    DSM dsm = builder.setType(DSMBuilder.TYPE.XML).create();
    Object pet = dsm.toObject(xmlStr); // read data from xml file
    System.out.println(pet); // read data from json file

    dsm = builder.setType(DSMBuilder.TYPE.JSON).create();
    Object petXml = dsm.toObject(jsonStr); // read data from xml file
    System.out.println(pet); // read data from json file
    System.out.println(petXml); // read data from json file
  }
}
