/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FarmerRole;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Harsh Shah
 */
public class WeatherInformationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WeatherInformationJPanel
     */

    public static Map<String, Object> jsonToMap(String str){
     Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {}.getType()
     );
     return map;
    }
    private JPanel userProcessContainer;
    public WeatherInformationJPanel(JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dayAfterTempText = new javax.swing.JTextField();
        nextDayTempText = new javax.swing.JTextField();
        currentTempText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        locationTxt = new javax.swing.JTextField();
        countryTxt = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Today");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel5.setText("Tomorrow");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel6.setText("Day After");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));
        add(dayAfterTempText, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 110, -1));
        add(nextDayTempText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 100, -1));

        currentTempText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentTempTextActionPerformed(evt);
            }
        });
        add(currentTempText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 80, -1));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 170, 130));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 150, 160, 150));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 170, 130));

        jButton1.setText("Request Weather");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, -1, -1));
        add(locationTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 110, -1));
        add(countryTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void currentTempTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentTempTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentTempTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean isMetric = true;
        String city = locationTxt.getText();
        String country  = countryTxt.getText();
        String API_KEY = "a7a00470c6e4c9a97cd76242259a08cf"; /* YOUR OWM API KEY HERE */
        String LOCATION = city+","+country;
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY + "&units=imperial";
        byte forecastDays = 3;

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = rd.readLine()) != null) {
                result.append(line);

            }
            rd.close();
            //System.out.println(result);
            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());

            System.out.println("Current Temperature: " +mainMap.get("temp"));
            System.out.println("Current Humidity: " +mainMap.get("humidity"));
            System.out.println("Wind Speeds: " +windMap.get("speed"));
            System.out.println("Wind Angle: " +windMap.get("deg"));

            double number = Double.parseDouble((String.valueOf(mainMap.get("temp"))));
            double wind = Double.parseDouble((String.valueOf(windMap.get("speed"))));
            double humid = Double.parseDouble((String.valueOf(mainMap.get("humidity"))));
            double min = number -3.0;
            double max  = number +3.0;
            currentTempText.setText(String.valueOf(number));
            nextDayTempText.setText(String.valueOf(min));
            dayAfterTempText.setText(String.valueOf(max));
            if (number>60.0 && wind > 0.0 && humid <= 20.0)
            {
                Image MyImage = new ImageIcon(this.getClass().getResource("/Images/sunny.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel1.setIcon(image);
            }
            else if (number>60.0 && wind > 0.0 && humid > 20.0 && humid <= 55.0)
            {
                Image MyImage = new ImageIcon(this.getClass().getResource("/Images/suncloud.png")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel1.setIcon(image);
            }
            else if(number>60.0 && wind > 2.0 && humid > 55.0)
            {
                Image MyImage = new ImageIcon(this.getClass().getResource("/Images/sunrain.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel1.setIcon(image);
            }
            else if(number>45.0 && number<=60.0 && wind > 0.5 && humid <= 30.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/cloud.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel1.setIcon(image);
            }
            else if(number>45.0 && number<=60.0 && wind > 2.0 && humid > 30.0 && humid <= 60.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/cloudlrain.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel1.setIcon(image);
            }
            else if(number>45.0 && number<=60.0 && wind > 3.5 && humid > 60.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/rain.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel1.setIcon(image);
            }
            else if(number<=45.0 && number>30.0 && wind > 0.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/cold.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel1.setIcon(image);
            }
            else if(number<=30.0 && wind > 0.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/verycold.png")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel1.setIcon(image);
            }
            if (min>60.0 && wind > 0.0 && humid <= 20.0)
            {
                Image MyImage = new ImageIcon(this.getClass().getResource("/Images/sunny.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel2.setIcon(image);
            }
            else if (min>60.0 && wind > 0.0 && humid > 20.0 && humid <= 55.0)
            {
                Image MyImage = new ImageIcon(this.getClass().getResource("/Images/suncloud.png")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel2.setIcon(image);
            }
            else if(min>60.0 && wind > 2.0 && humid > 55.0)
            {
                Image MyImage = new ImageIcon(this.getClass().getResource("/Images/sunrain.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel2.setIcon(image);
            }
            else if(min>45.0 && min<=60.0 && wind > 0.5 && humid <= 30.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/cloud.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel2.setIcon(image);
            }
            else if(min>45.0 && min<=60.0 && wind > 2.0 && humid > 30.0 && humid <= 60.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/cloudlrain.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel2.setIcon(image);
            }
            else if(min>45.0 && min<60.0 && wind > 3.5 && humid > 60.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/rain.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel2.setIcon(image);
            }
            else if(min<=45.0 && min>30.0 && wind > 0.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/cold.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel2.setIcon(image);
            }
            else if(min<=30.0 && wind > 0.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/verycold.png")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel2.setIcon(image);
            }
            if (max>60.0 && wind > 0.0 && humid <= 20.0)
            {
                Image MyImage = new ImageIcon(this.getClass().getResource("/Images/sunny.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel3.setIcon(image);
            }
            else if (max>60.0 && wind > 0.0 && humid > 20.0 && humid <= 55.0)
            {
                Image MyImage = new ImageIcon(this.getClass().getResource("/Images/suncloud.png")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel3.setIcon(image);
            }
            else if(max>60.0 && wind > 2.0 && humid > 55.0)
            {
                Image MyImage = new ImageIcon(this.getClass().getResource("/Images/sunrain.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel3.setIcon(image);
            }
            else if(max>45.0 && max<=60.0 && wind > 0.5 && humid <= 30.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/cloud.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel3.setIcon(image);
            }
            else if(max>45.0 && max<=60.0 && wind > 2.0 && humid > 30.0 && humid <= 60.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/cloudlrain.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel3.setIcon(image);
            }
            else if(max>45.0 && max<=60.0 && wind > 3.5 && humid > 60.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/rain.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel3.setIcon(image);
            }
            else if(max<=45.0 && max>30.0 && wind > 0.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/cold.jpg")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel3.setIcon(image);
            }
            else if(max<=30.0 && wind > 0.0)
            {Image MyImage = new ImageIcon(this.getClass().getResource("/Images/verycold.png")).getImage();;

                Image newImg = MyImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                jLabel3.setIcon(image);
            }

        }
        catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField countryTxt;
    private javax.swing.JTextField currentTempText;
    private javax.swing.JTextField dayAfterTempText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField locationTxt;
    private javax.swing.JTextField nextDayTempText;
    // End of variables declaration//GEN-END:variables
}