package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InfrastructureDepartment {
	
	public static final String BILLBOARD_FILE_NAME="data/billboard.bbd";
	public static final String IMPORT_DATA="data/BillboardDataExported.txt";
	private List<Billboard> billboard;
	
	public InfrastructureDepartment() {
		billboard=new ArrayList<Billboard>();
	}
	
	public void addBillboard(double w, double h, boolean iu,String b) {
		billboard.add(new Billboard(w, h, iu, b));
	}
	
	public String showBillboard() {
		String information="";
		information="W		H		inUse		Brand\n";
		for(int i=0;i<billboard.size();i++) {
			information+=billboard.get(i).getWidth()+"		"+billboard.get(i).getHeight()+"		";
			information+=billboard.get(i).isInUse()+"		"+billboard.get(i).getBrand()+"\n";	
		}
		information+="\n Total : "+billboard.size();
		return information;
	}
	
	@SuppressWarnings("unused")
	private void saveBillboard() {
		
	}
	
	@SuppressWarnings("unused")
	private void loadBillboard() {
	}
	
	public String exportDangerousBillboardReport() {
		int b=0;
		String message="===========================\r\n"+ "DANGEROUS BILLBOARD REPORT\r\n"+"===========================\r\n"+"";
		message+="The dangerous billboard are: \n";
		for(int i=0;i<billboard.size();i++) {
			if(billboard.get(i).calculateArea()>=160) {
				
				message+=(b+1)+". Billboard "+billboard.get(i).getBrand()+" with area "+billboard.get(i).calculateArea()+"cm^2 \n";
				b++;
			}
		}
		return message;
	}
	
	public void importData() throws IOException {
		BufferedReader br= new BufferedReader(new FileReader(IMPORT_DATA));
		String line= br.readLine();
		while(line!=null) {
			String[] part= line.split(";");
			Billboard register= new Billboard(Double.parseDouble(part[0]),Double.parseDouble(part[1]),Boolean.parseBoolean(part[2]),part[3]);
			billboard.add(register);
			line=br.readLine();
		}
		br.close();
	}
	
	public String toString() {
		String text="";
		return text;
	}

	public List<Billboard> getBillboard() {
		return billboard;
	}

}

