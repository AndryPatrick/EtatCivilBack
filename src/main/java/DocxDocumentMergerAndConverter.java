/**
 * 
 */
 
import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
 
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.io.internal.ByteArrayOutputStream;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.images.FileImageProvider;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
 
/**
 * @author Dhananjay Jha
 *
 */
public class DocxDocumentMergerAndConverter {
	/**
	 * Prend le chemin du fichier en entrée et renvoie le flux ouvert dessus
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public InputStream loadDocumentAsStream(String filePath) throws IOException{
		//URL url =new File(filePath).toURL();
		URL url =new File(filePath).toURI().toURL();
		InputStream documentTemplateAsStream=null;
		documentTemplateAsStream= url.openStream();
		return documentTemplateAsStream;
	}
	/**
	 * charge le rapport docx 
	 * @param documentTemplateAsStream
	 * @param freemarkerOrVelocityTemplateKind
	 * @return
	 * @throws IOException
	 * @throws XDocReportException
	 */
	public IXDocReport loadDocumentAsIDocxReport(InputStream documentTemplateAsStream, TemplateEngineKind freemarkerOrVelocityTemplateKind) throws IOException, XDocReportException{
		IXDocReport xdocReport = XDocReportRegistry.getRegistry().loadReport(documentTemplateAsStream, freemarkerOrVelocityTemplateKind);
		return xdocReport;
	}
	/**
	 * Prend l'instance IXDocReport, en crée une instance IContext et place les variables dans le contexte
	 * @param report
	 * @param variablesToBeReplaced
	 * @return
	 * @throws XDocReportException
	 */
	public IContext replaceVariabalesInTemplateOtherThanImages(IXDocReport report, Map<String, Object> variablesToBeReplaced) throws XDocReportException{
		IContext context = report.createContext();
		for(Map.Entry<String, Object> variable : variablesToBeReplaced.entrySet()){
			context.put(variable.getKey(), variable.getValue());
		}
		return context;
	}
	/**
	 * Prend la carte du nom de variable d'image et fileptah de l'image à remplacer. Crée IImageprovides et ajoute la variable dans le contexte
	 * @param report
	 * @param variablesToBeReplaced
	 * @param context
	 */
	public void replaceImagesVariabalesInTemplate(IXDocReport report, Map<String, String> variablesToBeReplaced, IContext context){
 
		 FieldsMetadata metadata = new FieldsMetadata();
         for(Map.Entry<String, String> variable: variablesToBeReplaced.entrySet()){
                 metadata.addFieldAsImage(variable.getKey());
                 context.put(variable.getKey(), new FileImageProvider(new File(variable.getValue()),true));
         }
         report.setFieldsMetadata(metadata);
 
	}
	/**
	 * Génère un tableau d'octets en sortie du modèle fusionné
	 * @param report
	 * @param context
	 * @return
	 * @throws XDocReportException
	 * @throws IOException
	 */
	public byte[] generateMergedOutput(IXDocReport report,IContext context ) throws XDocReportException, IOException{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		report.process(context, outputStream);
		return outputStream.toByteArray();
	}
	/**
	 * Prend les entrées et renvoie la sortie fusionnée sous forme d'octet []
	 * @param templatePath
	 * @param templateEngineKind
	 * @param nonImageVariableMap
	 * @param imageVariablesWithPathMap
	 * @return
	 * @throws IOException
	 * @throws XDocReportException
	 */
	public byte[] mergeAndGenerateOutput(String templatePath, TemplateEngineKind templateEngineKind, Map<String, Object> nonImageVariableMap,Map<String, String> imageVariablesWithPathMap ) throws IOException, XDocReportException{
		InputStream inputStream = loadDocumentAsStream(templatePath);
		IXDocReport xdocReport = loadDocumentAsIDocxReport(inputStream,templateEngineKind);
		IContext context = replaceVariabalesInTemplateOtherThanImages(xdocReport,nonImageVariableMap);
		replaceImagesVariabalesInTemplate(xdocReport, imageVariablesWithPathMap, context);
		byte[] mergedOutput = generateMergedOutput(xdocReport, context); 
		return mergedOutput;
	}
}