package uic.edu.ids.actionbean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import uic.edu.ids517.bmibean.DBAccessBean;
import uic.edu.ids517.bmibean.MessageBean;

public class ActionBeanFile {

	private MessageBean messageBean;
	private UploadedFile uploadedFile;
	private String uploadedFileContents = null;
	private DBAccessBean dbaseBean;
	private File fileLabel;
	private String fileName;
	private long fileSize;
	private boolean fileImport = false;
	private boolean fileImportError = true;
	private int numberRows;
	private ArrayList<DataBean> dataBean;
	private boolean renderParseTable;

	public String processFileUpload() {

		messageBean.setErrorMessage("");

		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> m = context.getExternalContext().getSessionMap();

		String path = context.getExternalContext().getRealPath("/temp");

		File tempFile = null;
		FileOutputStream fos = null;

		int nCols = 0;
		int n = 0;
		messageBean.setErrorMessage("");
		
		try {

			fileName = uploadedFile.getName();
			fileSize = uploadedFile.getSize();
			String fileContentType = uploadedFile.getContentType();

			// next line if want uploadin Stringfor memory processing
			uploadedFileContents = new String(uploadedFile.getBytes());

			tempFile = new File(path + "/" + fileName);
			fos = new FileOutputStream(tempFile);

			// next line if want file uploadedto disk
			fos.write(uploadedFile.getBytes());
			fos.close();

			Scanner s = new Scanner(tempFile);
			String input;
			Scanner d;

			input = s.nextLine();
			String[] strArr = input.split(",");
			System.out.println(input);

			nCols = strArr.length;
		    dataBean = new ArrayList<DataBean>(nCols);
			// variables- headerline
			for (int i = 0; i < nCols; i++) {
				dataBean.add(new DataBean());
				dataBean.get(i).setVariableName(strArr[i]);
				System.out.print(":" + strArr[i]);
			}

			String createQuery = "CREATETABLE" + fileLabel + "(";

			dbaseBean.setQueryType("INSERT");

			String insertQuery = "INSERTINTO " + fileLabel + "VALUES(null,";
			while (s.hasNext()) {
				input = s.nextLine();
				strArr = input.split(",");
				System.out.println(input);
				nCols = strArr.length;
				for (int i = 0; i < nCols; i++) {
					System.out.print(":" + strArr[i]);
					if (n == 0) {
						String type = "STRING";
						String dataType = "CATEGORICAL";

						try {
							Date dParse = Date.valueOf(strArr[i]);
							type = "DATE";
							dataType = "QUANTITATIVE";
						} catch (Exception e) {
							type = "STRING";
							dataType = "CATEGORICAL";
						}

						if (!type.equalsIgnoreCase("date"))
							try {
								Integer.parseInt(strArr[i]);
								type = "INTEGER";
								dataType = "COUNT";
							} catch (NumberFormatException e) {
								type = "STRING";
								dataType = "CATEGORICAL";
							}

						if ((!type.equalsIgnoreCase("integer"))
								&& (!type.equalsIgnoreCase("date")))
							try {
								Double.parseDouble(strArr[i]);//
								type = "DOUBLE";
								dataType = "QUANTITATIVE";
							} catch (NumberFormatException e) {
								type = "STRING";
								dataType = "CATEGORICAL";
							}

						dataBean.get(i).setDataType(type);
						dataBean.get(i).setDataValue(strArr[i]);
						dataBean.get(i).setVariableType(dataType);
					}
				}
				System.out.println(":");
				d = new Scanner(input);
				d.useDelimiter(",");
				n++;

				//s.close();
				numberRows = n;
				fileImport = true;
			}

		} catch (IOException e) {
			// TODO Auto-generatedcatchblock
			e.printStackTrace();
			messageBean.setErrorMessage("Errorreadingdata from file "
					+ fileName + ", label:" + fileLabel);
			fileImportError = true;
		}

		numberRows = n;
	   renderParseTable = true;

		return "SUCCESS";

	}
	
	public String processDataImport(){

		StringBuffer sb = new StringBuffer(
		                          "CREATETABLE" +fileLabel+" (int idKey AUTOINCREMENT,"   );
		int nCols= (dataBean== null)? 0 :dataBean.size();
		System.out.println("ncols:" + nCols);

		for(int i=0; i<nCols;i++) {
		System.out.println(
		dataBean.get(i).getVariableName()+ "\t" +
		dataBean.get(i).getDataValue()+ "\t" +
		dataBean.get(i).getDataType()+ "\t" +
		dataBean.get(i).getVariableType()+ "\t"    );
		sb.append(dataBean.get(i).getDataType()+ " " +
		dataBean.get(i).getVariableName());
		if(i != (nCols-1))
		sb.append(",");
		          }
		sb.append(") PRIMARYKEY (idKey)");
		          // System.out.println(sb.toString());
		return"SUCCESS";
		      } 

	
	
	public String  processFileDownload(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();

		FileOutputStream fos = null;

		          String path = fc.getExternalContext().getRealPath("/temp");
		          String tableName= "user";
		          String fileNameBase= tableName+ ".csv";

		          String fileName= path + "/" +
		"f14g46"+"_" + fileNameBase;

		         File f = new File(fileName);

		dbaseBean.setQueryType("SELECT");
		//dbaseBean.executeSQL(sqlQuery);
		          Result result= ResultSupport.toResult(dbaseBean.getResultSet());
		          Object[][] sData= result.getRowsByIndex();

		          String columnNames[] = result.getColumnNames();
		StringBuffer sb = new StringBuffer();
		try {
		fos = new FileOutputStream(fileName);

		for(int i=0; i<columnNames.length;i++) {
		sb.append(columnNames[i].toString()+ ",");
		              }

		sb.append("\n");

		fos.write(sb.toString().getBytes());

		for(int i = 0; i<sData.length;i++) {
		sb = new StringBuffer();
		for(int j=0; j<sData[0].length;j++) {
		sb.append(sData[i][j].toString()+ ",");
		                  }

					sb.append("\n");
					fos.write(sb.toString().getBytes());
				}	
					
				fos.flush();
				fos.close();
			}	
		catch(FileNotFoundException e) {
		              // TODO Auto-generatedcatchblock
		e.printStackTrace();
		          } catch(IOException e) {
		              // TODO Auto-generatedcatchblock
		e.printStackTrace();
		          }


		          String mimeType= ec.getMimeType(fileName);

		FileInputStream in = null;
		byte b;

		ec.responseReset();
		ec.setResponseContentType(mimeType); 
		ec.setResponseContentLength((int)f.length());
		ec.setResponseHeader(
		              "Content-Disposition",
		              "attachment;filename=\""+ fileNameBase+ "\"");

		try {

		in = new FileInputStream(f);
		OutputStream output= ec.getResponseOutputStream();
		while(true){
		                  b = (byte)in.read();
		if(b < 0)
		break;
		output.write(b);
		              }
		          } catch(IOException e) {
		              // TODO Auto-generatedcatchblock
		e.printStackTrace();
		          }
		finally{
			try {
				 in.close();
				 } catch (IOException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
				 }
			 }
				fc.responseComplete();
			 return "SUCCESS";

	}
	
	

	/**
	 * @return the messageBean
	 */
	public MessageBean getMessageBean() {
		return messageBean;
	}

	/**
	 * @param messageBean the messageBean to set
	 */
	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
	}

	/**
	 * @return the dbaseBean
	 */
	public DBAccessBean getDbaseBean() {
		return dbaseBean;
	}

	/**
	 * @param dbaseBean the dbaseBean to set
	 */
	public void setDbaseBean(DBAccessBean dbaseBean) {
		this.dbaseBean = dbaseBean;
	}

	/**
	 * @return the uploadedFile
	 */
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * @param uploadedFile the uploadedFile to set
	 */
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	/**
	 * @return the fileLabel
	 */
	public File getFileLabel() {
		return fileLabel;
	}

	/**
	 * @param fileLabel the fileLabel to set
	 */
	public void setFileLabel(File fileLabel) {
		this.fileLabel = fileLabel;
	}

	/**
	 * @return the fileImport
	 */
	public boolean isFileImport() {
		return fileImport;
	}

	/**
	 * @param fileImport the fileImport to set
	 */
	public void setFileImport(boolean fileImport) {
		this.fileImport = fileImport;
	}

	/**
	 * @return the fileImportError
	 */
	public boolean isFileImportError() {
		return fileImportError;
	}

	/**
	 * @param fileImportError the fileImportError to set
	 */
	public void setFileImportError(boolean fileImportError) {
		this.fileImportError = fileImportError;
	}

	/**
	 * @return the numberRows
	 */
	public int getNumberRows() {
		return numberRows;
	}

	/**
	 * @param numberRows the numberRows to set
	 */
	public void setNumberRows(int numberRows) {
		this.numberRows = numberRows;
	}

	/**
	 * @return the dataBean
	 */
	public ArrayList<DataBean> getDataBean() {
		return dataBean;
	}

	/**
	 * @param dataBean the dataBean to set
	 */
	public void setDataBean(ArrayList<DataBean> dataBean) {
		this.dataBean = dataBean;
	}

	/**
	 * @return the renderParseTable
	 */
	public boolean isRenderParseTable() {
		return renderParseTable;
	}

	/**
	 * @param renderParseTable the renderParseTable to set
	 */
	public void setRenderParseTable(boolean renderParseTable) {
		this.renderParseTable = renderParseTable;
	}

}
