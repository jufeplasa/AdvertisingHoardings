package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class InfrastructureDepartment {
	
	public static final String BILLBOARD_FILE_NAME="data/billboard.bbd";
	public static final String IMPORT_DATA="data/BillboardDataExported.txt";
	public static final String EXPORT_DATA="data/BillboardDataExported.csv";
	public static final String REPORT="data/report.txt";
	public static final String SAVE_DATA="data/Billboards.plaza";
	
	private List<Billboard> billboard;
	
	public InfrastructureDepartment() {
		billboard=new ArrayList<Billboard>();
	}
	
	public String addBillboard(double w, double h, boolean iu,String b) throws IOException {
		String message="";
		if(billboard.add(new Billboard(w, h, iu, b))) {
			saveBillboard();
			FileWriter fw= new FileWriter(EXPORT_DATA, true);
			fw.write(w+"++"+h+"++"+iu+"++"+b+"\n");
			fw.close();
			message="";
		}
		return message;
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
	
	private void saveBillboard() throws FileNotFoundException, IOException {
		ObjectOutputStream oos= new ObjectOutputStream (new FileOutputStream(SAVE_DATA));
		oos.writeObject(billboard);
		oos.close();
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	private void loadBillboard() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f=new File(SAVE_DATA);
		if(f.exists()) {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(f));
			billboard= (List<Billboard>) ois.readObject();
			ois.close();
		}
	}
	
	public String exportDangerousBillboardReport() throws IOException {
		int b=0;
		FileWriter fw= new FileWriter(REPORT, false);
		String message="===========================\r\n"+ "DANGEROUS BILLBOARD REPORT\r\n"+"===========================\r\n"+"";
		message+="The dangerous billboard are: \n";
		for(int i=0;i<billboard.size();i++) {
			if(billboard.get(i).calculateArea()>=160) {
				
				message+=(b+1)+". Billboard "+billboard.get(i).getBrand()+" with area "+billboard.get(i).calculateArea()+"cm^2 \n";
				fw.write((b+1)+". Billboard "+billboard.get(i).getBrand()+" with area "+billboard.get(i).calculateArea()+"cm^2 \n");
				b++;
				
			}
		}
		fw.close();
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

