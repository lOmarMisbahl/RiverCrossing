import Crossers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
        try {
            try {
                Farmer farmer = new Farmer();
                Wolf Wolf = new Wolf();
                Sheep Sheep = new Sheep();
                Plant Plant = new Plant();
                Save = GameEngine.getInstance();
                File Saves = new File("Saves.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                //doc is an object that we use to access the xml file i guess
                Document doc = dBuilder.parse(Saves);
                doc.getDocumentElement().normalize();
                NodeList LeftBank = doc.getElementsByTagName("LeftBank");
                NodeList RightBank = doc.getElementsByTagName("RightBank");
                NodeList OnBoat = doc.getElementsByTagName("OnBoat");
                NodeList Sails = doc.getElementsByTagName("Save");

                Node LeftBankN = LeftBank.item(0);
                System.out.println(LeftBank.item(0).getChildNodes().item(0).getNodeName());
                Element eElementL = (Element) LeftBankN;
                try {
                    if (eElementL.getElementsByTagName("Farmer").item(0).getTextContent().equals("1"))
                        Save.leftBank.add(farmer);
                    if (eElementL.getElementsByTagName("Wolf").item(0).getTextContent().equals("1"))
                        Save.leftBank.add(Wolf);
                    if (eElementL.getElementsByTagName("Sheep").item(0).getTextContent().equals("1"))
                        Save.leftBank.add(Sheep);
                    if (eElementL.getElementsByTagName("Plant").item(0).getTextContent().equals("1"))
                        Save.leftBank.add(Plant);
                } catch (NullPointerException N) {
                    N.printStackTrace();
                }

                Node RightBankN = RightBank.item(0);
                Element eElementR = (Element) RightBankN;
                try {
                    if (eElementR.getElementsByTagName("Farmer").item(0).getTextContent().equals("1"))
                        Save.rightBank.add(farmer);
                    if (eElementR.getElementsByTagName("Wolf").item(0).getTextContent().equals("1"))
                        Save.rightBank.add(Wolf);
                    if (eElementR.getElementsByTagName("Sheep").item(0).getTextContent().equals("1"))
                        Save.rightBank.add(Sheep);
                    if (eElementR.getElementsByTagName("Plant").item(0).getTextContent().equals("1"))
                        Save.rightBank.add(Plant);
                } catch (NullPointerException N) {
                    N.printStackTrace();
                }

                Node OnBoatN = OnBoat.item(0);
                Element eElementO = (Element) OnBoatN;
                try {
                    if (eElementO.getElementsByTagName("Farmer").item(0).getTextContent().equals("1"))
                        Save.boatRiders.add(farmer);
                    if (eElementO.getElementsByTagName("Wolf").item(0).getTextContent().equals("1"))
                        Save.boatRiders.add(Wolf);
                    if (eElementO.getElementsByTagName("Sheep").item(0).getTextContent().equals("1"))
                        Save.boatRiders.add(Sheep);
                    if (eElementO.getElementsByTagName("Plant").item(0).getTextContent().equals("1"))
                        Save.boatRiders.add(Plant);
                } catch (NullPointerException N) {
                    N.printStackTrace();
                }
                Node SailN = Sails.item(0);
                Element eElementS = (Element) SailN;
                try {
                    Save.sails = Integer.parseInt(eElementS.getElementsByTagName("Sails").item(0).getTextContent());
                } catch (NullPointerException N) {
                    N.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (NullPointerException N){
            N.printStackTrace();
        }
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
