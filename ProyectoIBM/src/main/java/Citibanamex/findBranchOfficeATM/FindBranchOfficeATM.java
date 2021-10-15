package Citibanamex.findBranchOfficeATM;

import java.util.ArrayList;


import com.fasterxml.jackson.databind.JsonNode;
import Citibanamex.consumeAPI.ConsumeAPI;
import Citibanamex.convertToJsonNode.ConvertToJesonNode;
import Citibanamex.model.BranchOfficeATMModel;
import Citibanamex.model.Coordenadas;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FindBranchOfficeATM {

	public ArrayList<BranchOfficeATMModel> findBranchOffice(Coordenadas coordenadas) {
		 String[] keys = new String[] {"100","110","300","400","500","600","800","900","950"};
		 String[] arre = new String[] {"0","1"};
		 int fin = 300000;
		ArrayList<BranchOfficeATMModel> sucursal = new ArrayList<BranchOfficeATMModel>();
		ConsumeAPI c = new ConsumeAPI();
		ConvertToJesonNode jNode = new ConvertToJesonNode();
		JsonNode jsonNode = jNode.getJsonNode(c.getJson());
		if (jsonNode.get("Servicios") != null) {
			for (JsonNode node : jsonNode) {
				for (int j = 0; j < keys.length; j++) {
					for (int k = 0; k < arre.length; k++) {
						for (int i = 1; i <= fin; i++) {
							if (node.get(keys[j]).get(arre[k]).get(String.valueOf(i)) != null) {
								String lo = String
										.valueOf(node.get(keys[j]).get(arre[k]).get(String.valueOf(i)).get(15));
								String la = String
										.valueOf(node.get(keys[j]).get(arre[k]).get(String.valueOf(i)).get(16));
								float longitud = Float.parseFloat(lo.replace("\"", " "));
								float latitud = Float.parseFloat(la.replace("\"", " "));

								if ((coordenadas.getLatitud() == latitud && longitud == coordenadas.getLongitud())) {

									BranchOfficeATMModel m = new BranchOfficeATMModel();
									m.setStreet(String
											.valueOf(node.get(keys[j]).get(arre[k]).get(String.valueOf(i)).get(3)));
									m.setCologne(String
											.valueOf(node.get(keys[j]).get(arre[k]).get(String.valueOf(i)).get(4)));
									m.setReferenceStreet(String
											.valueOf(node.get(keys[j]).get(arre[k]).get(String.valueOf(i)).get(6)));
									m.setBranchOfficeATM(String
											.valueOf(node.get(keys[j]).get(arre[k]).get(String.valueOf(i)).get(19)));
									sucursal.add(m);
								}

							}
						}
					}
				}
			}
			log.info("return the list");
		}
		return sucursal;
	}
	
}
