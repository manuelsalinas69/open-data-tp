/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.pol.opendata.tp.parser;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mpoletti
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        double contadorExito=0,contadorFallo=0;
        PdfTextParser p=new PdfTextParser();
        
        String csv = "G:\\muebles_2014\\csv\\PDTE_HAYES.csv";
        //        File outFile= new File(csv);
        //        if(outFile.exists()){
        //            outFile.delete();
        //        }
        //
        //        outFile.createNewFile();
        
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        List<String[]> data = new ArrayList<String[]>();
        
        String pdfToText = p.pdftoText("G:\\muebles_2014\\PDTE. HAYES.pdf");
        int y=0;
        //for(y=631;y<=3514;y++){
        //String pdfToText = p.pdftoText("/home/mpoletti/Escritorio/opendata/muebles_2014/capital/CAPITAL-"+y+".pdf");
        //System.out.println("abrio pdf "+y);
        //if (y==632)
        //p.writeTexttoFile(pdfToText,"/home/mpoletti/Escritorio/opendata/muebles_2014/capital/CAPITAL"+y+".txt" );
        //p.writeTexttoFile(pdfToText,"/home/mpoletti/Escritorio/opendata/muebles_2014/CAPITAL.txt" );
        if (pdfToText == null) {
            System.out.println("PDF to Text Conversion failed.");
        }
        else {
            //System.out.println("\nThe text parsed from the PDF Document....\n" + pdfToText);
            //p.writeTexttoFile(pdfToText, "/home/mpoletti/Escritorio/opendata/muebles_2014/nuevo.txt");
            String unidadJerarquica,codigoReparticion,nombreReparticion,codigoDependencia,nombreDependencia,area;
            String cuenta,subcuenta,especificacion,descripcion,fechaAdquisicion,rotulado,cantidad,valorUnitario,valorTotal,estadoConservacion,diferencia=" ",barras;
            String contenido;
            String linea;
            String aux;
            String[] contenidoParts;
            String[] lineaP;
            try{
                //descarta todlo lo que esta antes
                String[] parts = pdfToText.split("UNI. JERARQUICA ",2);
                parts[0]=null;
                pdfToText=parts[1];
                Boolean flag=true;
                while(flag){
                    System.out.println("primer loop: "+y);
                    y++;
                    flag=false;
                    //EMPIEZA EL CICLO
                    //saca unidad jerarquica
                    parts = pdfToText.split("\n",2);
                    unidadJerarquica = parts[0];
                    pdfToText=parts[1];
                    
                    //saca codigo y nombre de reparticion si hay
                    parts = pdfToText.split("(2)",2);
                    parts[0]=null;
                    pdfToText=parts[1];
                    parts = pdfToText.split("\n",2);
                    parts[0]=null;
                    pdfToText=parts[1];
                    parts = pdfToText.split("\n",2);
                    codigoReparticion = parts[0];
                    pdfToText=parts[1];
                    parts = codigoReparticion.split(" ",2);
                    codigoReparticion = parts[0];
                    if(parts.length>1)
                        nombreReparticion=parts[1];
                    else  nombreReparticion="No Tiene";
                    
                    
                    //saca codigo y nombre de Dependencia si hay
                    parts= pdfToText.split("(18)",2);
                    parts[0]=null;
                    pdfToText=parts[1];
                    parts = pdfToText.split("\n",2);
                    parts[0]=null;
                    pdfToText=parts[1];
                    parts = pdfToText.split("\n",2);
                    codigoDependencia=parts[0];
                    pdfToText=parts[1];
                    parts=codigoDependencia.split(" ",2);
                    codigoDependencia=parts[0];
                    if(parts.length>1)
                        nombreDependencia=parts[1];
                    else nombreDependencia="No tiene";
                    
                    //saca el area
                    parts=pdfToText.split("\n",2);
                    area=parts[0];
                    pdfToText=parts[1];
                    
                    //separa las filas de datos del resto del documento
                    parts=pdfToText.split("UNI. JERARQUICA ",2);
                    contenido=parts[0];
                    if(!(parts.length>1)){
                        flag=false;
                        
                    }
                    else {
                        pdfToText=parts[1];
                        flag=true;
                    }
                    contenidoParts=contenido.split("JEFE DE DEPENDENCIA JEFE DE PATRIMONIO DIRECTOR ADMINISTRATIVO");
                    contenido=contenidoParts[0];
                    contenidoParts=contenido.split("DEPARTAMENTO DE BIENES PATRIMONIALES");
                    contenido=contenidoParts[0];
                    
                    contenidoParts = contenido.split("\n",2);
                    linea = contenidoParts[0];
                    linea=linea.replaceAll("\\s+", " ");
                    
                    //sacar una linea
                    Boolean flag2=true;
                    while (flag2){
                        System.out.println("degundo loop: "+y);
                        //if(y==632) System.out.println("linea: "+linea);
                        flag2=false;
                        contadorExito++;
                        try{
                            //System.out.println("contenido:"+contenido);
                            //sacar cuenta
                            lineaP=linea.split(" ",2);
                            cuenta=lineaP[0];
                            linea=lineaP[1];
                            //sacar subcuenta
                            lineaP=linea.split(" ",2);
                            subcuenta=lineaP[0];
                            linea=lineaP[1];
                            //sacarespecificacion
                            lineaP=linea.split(" ",2);
                            especificacion=lineaP[0];
                            linea=lineaP[1];
                            //sacar rotulado
                            //System.out.println("linea:"+linea);
                            lineaP=linea.split(" ",3);
                            rotulado = lineaP[0]+" - "+(String)lineaP[1];
                            linea=lineaP[2];
                            //sacar cantidad
                            lineaP=linea.split(" ",2);
                            cantidad=lineaP[0];
                            linea=lineaP[1];
                            //sacar valorunitario
                            //System.out.println("linea:"+linea);
                            int corte=0;
                            String corteString="";
                            corteString=linea.substring(0,3);
                            if((corteString.charAt(0) >= '0') && (corteString.charAt(0) <= '9') ){
                                corte++;
                                if((corteString.charAt(1) >= '0') && (corteString.charAt(1) <= '9') ){
                                    corte++;
                                    if((corteString.charAt(2) >= '0') && (corteString.charAt(2) <= '9') ){
                                        corte++;
                                    }else{
                                        corteString=corteString.substring(0,2);
                                    }
                                }else{
                                    corteString=corteString.substring(0,1);
                                }
                                
                            }
                            valorUnitario=corteString;
                            linea=linea.substring(corte);
                            //lineaP=linea.split("\\.",2);
                            if(linea.charAt(0)=='.'){
                                valorUnitario=valorUnitario+linea.substring(0,4);
                                linea=linea.substring(4);
                                //valorUnitario=valorUnitario+linea.substring(0,3);
                                //linea=linea.substring(3);
                                if (linea.charAt(0)=='.'){
                                    valorUnitario=valorUnitario+linea.substring(0,4);
                                    linea=linea.substring(4);
                                }
                            }
                            
                            fechaAdquisicion="";
                            descripcion="";
                            Boolean x=true;
                            
                            lineaP=linea.split(" ",2);
                            if(esFecha(lineaP[0])){
                                x=false;
                                fechaAdquisicion=lineaP[0];
                            }else{
                                descripcion=lineaP[0];
                                if(lineaP.length>1)
                                    linea=lineaP[1];
                                else{
                                    contenidoParts = contenido.split("\n",2);
                                    linea = contenidoParts[0];
                                    linea=linea.replaceAll("\\s+", " ");
                                    //System.out.println("linea: "+linea);
                                    if(contenidoParts.length>1)
                                        contenido = contenidoParts[1];
                                }
                            }
                            //if (y%100==0) System.out.println("procesando: "+y);
                            
                            while(x){
                                System.out.println("tercer loop: "+y);
                                lineaP=linea.split(" ",2);
                                aux=lineaP[0];
                                if(lineaP.length>1)
                                    linea=lineaP[1];
                                else{
                                    contenidoParts = contenido.split("\n",2);
                                    linea = contenidoParts[0];
                                    linea=linea.replaceAll("\\s+", " ");
                                    //System.out.println("linea: "+linea);
                                    if(contenidoParts.length>1)
                                        contenido = contenidoParts[1];
                                    else x=false;
                                }
                                
                                if(esFecha(aux)==false){
                                    descripcion=descripcion+" "+aux;
                                }
                                else{
                                    fechaAdquisicion=aux;
                                    x=false;
                                }
                            }
                            //sacar valorTotal
                            linea=linea.substring(2);
                            lineaP=linea.split(" ",2);
                            valorTotal=lineaP[0];
                            linea=lineaP[1];
                            /*
                             * lineaP=linea.split("\\.",2);
                             * valorTotal=lineaP[0]+".";
                             * linea=lineaP[1];
                             * valorTotal=valorTotal+linea.substring(0, 3);
                             * linea=linea.substring(3);
                             * if(linea.charAt(0)=='.'){
                             * valorTotal=valorTotal+linea.substring(0,4);
                             * linea=linea.substring(4);
                             * }
                             * linea=linea.substring(1);
                             */
                            //sacar estadoconsesrvacion
                            lineaP=linea.split(" ",2);
                            estadoConservacion=lineaP[0];
                            linea=lineaP[1];
                            if("Muy".equals(estadoConservacion)){
                                lineaP=linea.split(" ",2);
                                estadoConservacion=estadoConservacion+" "+lineaP[0];
                                linea=lineaP[1];
                            }
                            
                            barras=linea;
                            
                            valorTotal=valorTotal.replace(".", "");
                            valorUnitario=valorUnitario.replace(".", "");
                            if (checkData(unidadJerarquica,codigoReparticion,nombreReparticion,codigoDependencia,nombreDependencia,area,cuenta,subcuenta,especificacion,descripcion,fechaAdquisicion,rotulado,cantidad,valorUnitario,valorTotal,estadoConservacion,diferencia,barras)) {
                                data.add(new String[] {unidadJerarquica,codigoReparticion,nombreReparticion,codigoDependencia,nombreDependencia,area,cuenta,subcuenta,especificacion,descripcion,fechaAdquisicion,rotulado,cantidad,valorUnitario,valorTotal,estadoConservacion,diferencia,barras});
                                
                            }
                            
                            //System.out.println("linea:"+linea);
                            
                            //int i=0;
                            
                            /*System.out.println("\n");
                             * System.out.print(""+unidadJerarquica);
                             * System.out.print(","+codigoReparticion);
                             * System.out.print(","+nombreReparticion);
                             * System.out.print(","+codigoDependencia);
                             * System.out.print(","+nombreDependencia);
                             * System.out.print(","+area);
                             * System.out.print(","+cuenta);
                             * System.out.print(","+subcuenta);
                             * System.out.print(","+especificacion);
                             * System.out.print(","+descripcion);
                             * System.out.print(","+fechaAdquisicion);
                             * System.out.print(","+rotulado);
                             * System.out.print(","+cantidad);
                             * System.out.print(","+valorUnitario);
                             * System.out.print(","+valorTotal);
                             * System.out.print(","+estadoConservacion);
                             * System.out.print(","+barras);
                             */
                            //System.out.println("linea:" +linea);
                            //System.out.println("linea: "+linea);
                            
                            //System.out.println("contenido: "+contenido);
                            
                            //System.out.println("largo restante: "+pdfToText.length());
                        }
                        catch(Exception e){
                            System.out.print("\n");
                            System.out.println("linea imposible de leer"+y);
                            contadorFallo++;
                        }
                        contenidoParts = contenido.split("\n",2);
                        linea = contenidoParts[0];
                        linea=linea.replaceAll("\\s+", " ");
                        //System.out.println("linea: "+linea);
                        if(contenidoParts.length>1){
                            contenido = contenidoParts[1];
                            flag2=true;
                        }
                        else {flag2=false;}
                    }
                    
                }
            }
            catch(Exception e){
                System.out.println("pagina no adecuanada"+y);
            }
        }
        
        writer.writeAll(data);
        
        writer.close();
        //}
        System.out.println("\n");
        System.out.println("Exitos: "+contadorExito);
        System.out.println("Fallos: "+contadorFallo);
    }
    
    private static boolean checkData(String unidadJerarquica, String codigoReparticion, String nombreReparticion, String codigoDependencia, String nombreDependencia, String area, String cuenta, String subcuenta, String especificacion, String descripcion, String fechaAdquisicion, String rotulado, String cantidad, String valorUnitario, String valorTotal, String estadoConservacion, String diferencia, String barras) {
        try {
            int cant= Integer.parseInt(cantidad);
            
            long cantValor=Long.parseLong(valorTotal);
            
            long cantValor2=Long.parseLong(valorUnitario);
            return true;
        } catch (Exception e) {
            //System.err.println("No se pudo validar los datos de la linea--> ");
        }
        return false;
    }
    
    public String palabra(String p, int i){
        String resultado= "";
        
        return resultado;
    }
    
    public static Boolean esFecha(String c){
        Boolean r=true;
        if(c.length()<10)
            return false;
        if((c.charAt(0) < '1') && (c.charAt(0) > '2')){
            r=false;
        }
        if((c.charAt(1) < '0') && (c.charAt(1) > '9')){
            r=false;
        }
        if((c.charAt(2) < '0') && (c.charAt(2) > '9')){
            r=false;
        }
        if((c.charAt(3) < '0') && (c.charAt(3) > '9')){
            r=false;
        }
        if(c.charAt(4)!='-'){
            r=false;
        }
        if((c.charAt(5) < '0') && (c.charAt(5) > '9')){
            r=false;
        }
        if((c.charAt(6) < '0') && (c.charAt(6) > '9')){
            r=false;
        }
        if(c.charAt(7)!='-'){
            r=false;
        }
        if((c.charAt(8) < '0') && (c.charAt(8) > '9')){
            r=false;
        }
        if((c.charAt(9) < '0') && (c.charAt(9) > '9')){
            r=false;
        }
        
        
        return r;
    }
}
