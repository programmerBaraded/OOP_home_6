import java.io.FileWriter;
import java.io.IOException;

import javax.xml.crypto.OctetStreamData;

public class XMLSaver implements Saver{
    private final Order order;

    public XMLSaver (Order order){
        this.order = order;
    }

    @Override
    public void save() {
        String fileName = "order.xml";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\"" + order.getClientName() + "\",\n");
            writer.write("\"product\":\"" + order.getProduct() + "\",\n");
            writer.write("\"qnt\":" + order.getQnt() + ",\n");
            writer.write("\"price\":" + order.getPrice() + "\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
