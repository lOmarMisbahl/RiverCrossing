import Crossers.Farmer;
import Crossers.Plant;
import Crossers.Sheep;
import Crossers.Wolf;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class FilesParser {

    GameEngine Save;

    public void ReadSaveGame() {
    }

    public void WriteSaveGame() {
        try {
            Save = GameEngine.getInstance();

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();


            // root element
            Element root = document.createElement("Saves");
            document.appendChild(root);

            Element Saves = document.createElement("Save");
            root.appendChild(Saves);

            Element Left = document.createElement("LeftBank");
            Saves.appendChild(Left);

            Element Right = document.createElement("RightBank");
            Saves.appendChild(Right);

            Element OnBoat = document.createElement("OnBoat");
            Saves.appendChild(OnBoat);

            int temp;


            for (temp = 0; temp < Save.leftBank.size(); temp++) {

                if (Save.leftBank.get(temp) instanceof Farmer) {
                    Element Farmer = document.createElement("Farmer");
                    Farmer.appendChild(document.createTextNode("1"));
                    Left.appendChild(Farmer);
                } else if (Save.leftBank.get(temp) instanceof Wolf) {
                    Element Wolf = document.createElement("Wolf");
                    Wolf.appendChild(document.createTextNode("1"));
                    Left.appendChild(Wolf);
                } else if (Save.leftBank.get(temp) instanceof Sheep) {
                    Element Sheep = document.createElement("Sheep");
                    Sheep.appendChild(document.createTextNode("1"));
                    Left.appendChild(Sheep);
                } else if (Save.leftBank.get(temp) instanceof Plant) {
                    Element Plant = document.createElement("Plant");
                    Plant.appendChild(document.createTextNode("1"));
                    Left.appendChild(Plant);
                }
            }

            for (temp = 0; temp < Save.rightBank.size(); temp++) {

                if (Save.rightBank.get(temp) instanceof Farmer) {
                    Element Farmer = document.createElement("Farmer");
                    Farmer.appendChild(document.createTextNode("1"));
                    Right.appendChild(Farmer);
                } else if (Save.rightBank.get(temp) instanceof Wolf) {
                    Element Wolf = document.createElement("Wolf");
                    Wolf.appendChild(document.createTextNode("1"));
                    Right.appendChild(Wolf);
                } else if (Save.rightBank.get(temp) instanceof Sheep) {
                    Element Sheep = document.createElement("Sheep");
                    Sheep.appendChild(document.createTextNode("1"));
                    Right.appendChild(Sheep);
                } else if (Save.rightBank.get(temp) instanceof Plant) {
                    Element Plant = document.createElement("Plant");
                    Plant.appendChild(document.createTextNode("1"));
                    Right.appendChild(Plant);
                }
            }

            for (temp = 0; temp < Save.boatRiders.size(); temp++) {

                if (Save.boatRiders.get(temp) instanceof Farmer) {
                    Element Farmer = document.createElement("Farmer");
                    Farmer.appendChild(document.createTextNode("1"));
                    OnBoat.appendChild(Farmer);
                } else if (Save.boatRiders.get(temp) instanceof Wolf) {
                    Element Wolf = document.createElement("Wolf");
                    Wolf.appendChild(document.createTextNode("1"));
                    OnBoat.appendChild(Wolf);
                } else if (Save.boatRiders.get(temp) instanceof Sheep) {
                    Element Sheep = document.createElement("Sheep");
                    Sheep.appendChild(document.createTextNode("1"));
                    OnBoat.appendChild(Sheep);
                } else if (Save.boatRiders.get(temp) instanceof Plant) {
                    Element Plant = document.createElement("Plant");
                    Plant.appendChild(document.createTextNode("1"));
                    OnBoat.appendChild(Plant);
                }
            }

            Element Sails = document.createElement("Sails");
            Sails.appendChild(document.createTextNode(Integer.toString(Save.sails)));
            Saves.appendChild(Sails);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("Saves.xml"));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();

        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
