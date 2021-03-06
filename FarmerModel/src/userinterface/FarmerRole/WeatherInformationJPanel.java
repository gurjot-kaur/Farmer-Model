
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FarmerRole;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

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
        populateCombo();
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
        requestWeather = new javax.swing.JButton();
        locationTxt = new javax.swing.JTextField();
        countryTxt = new javax.swing.JTextField();
        rmCoboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        back = new javax.swing.JButton();
        currentDayHigh = new javax.swing.JTextField();
        tomDayHigh = new javax.swing.JTextField();
        dayAfterHigh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Today");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 95, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tomorrow");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 95, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Day After");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 89, -1, -1));

        dayAfterTempText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(dayAfterTempText, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 129, 110, -1));

        nextDayTempText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(nextDayTempText, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 135, 100, -1));

        currentTempText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentTempText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentTempTextActionPerformed(evt);
            }
        });
        add(currentTempText, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 135, 90, -1));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 227, 170, 159));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 227, 160, 150));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 227, 170, 150));

        requestWeather.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        requestWeather.setText("Request Weather");
        requestWeather.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestWeatherActionPerformed(evt);
            }
        });
        add(requestWeather, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 465, -1, -1));

        locationTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(locationTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 110, -1));

        countryTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(countryTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 110, -1));

        rmCoboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rmCoboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmCoboBoxActionPerformed(evt);
            }
        });
        add(rmCoboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 170, 30));

        txtNotes.setColumns(20);
        txtNotes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNotes.setRows(5);
        txtNotes.setEnabled(false);
        jScrollPane1.setViewportView(txtNotes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 520, 740, 190));

        back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-icon (2).png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 728, -1, -1));

        currentDayHigh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(currentDayHigh, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 181, 90, -1));

        tomDayHigh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(tomDayHigh, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 181, 100, -1));

        dayAfterHigh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(dayAfterHigh, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 181, 110, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Minimum");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 141, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Maximum");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 184, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Suggestions");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 526, 127, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Crop");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 90, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("City");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 110, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Country");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 110, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Weather-icon (1).png"))); // NOI18N
        jLabel13.setText("Weather Updates ");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 12, 330, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void currentTempTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentTempTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentTempTextActionPerformed

    private void requestWeatherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestWeatherActionPerformed
        // TODO add your handling code here:
    if (locationTxt.getText().equals("") || countryTxt.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null,"Please enter the city and country name");
    }
    else
    {
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
            Random rand = new Random();
            double random = Math.random() * 6;
            double random1 = Math.random() * 8;
            double random3 = Math.random() *6;
            random3 = Math.round(random3*100.0)/100.0;
            double numberhigh = number + random3;
            numberhigh = Math.round(numberhigh*100.0)/100.0;
            double min = number - random;
            min = Math.round(min*100.0)/100.0;
            double minhigh = min + random3;
            minhigh = Math.round(minhigh*100.0)/100;
            double max  = number + random1;
            max = Math.round(max*100.0)/100.0;
            double maxhigh = max + random3;
            maxhigh = Math.round(maxhigh*100.0)/100.0;
            currentTempText.setText(String.valueOf(number));
            nextDayTempText.setText(String.valueOf(min));
            dayAfterTempText.setText(String.valueOf(max));
            currentDayHigh.setText(String.valueOf(numberhigh));
            tomDayHigh.setText(String.valueOf(minhigh));
            dayAfterHigh.setText(String.valueOf(maxhigh));
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
        String crop = (String) rmCoboBox.getSelectedItem();
        String location = (String) locationTxt.getText();
        double number = Double.parseDouble(currentTempText.getText());
        if(crop.equals("snap peas") && location.equalsIgnoreCase("Boston") && number > 50.0 && number < 70.0 ) {
            int delay = 3000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                txtNotes.setText("Perfect conditions to grow snap peas and use biosolids for the best results");
                    Font font = new Font ("It is ideal to grow tomato",Font.BOLD,20);
            txtNotes.setFont(font);
      }
  };            Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        } 
        else if(crop.equals("snap peas") && location.equalsIgnoreCase("Boston") && number <= 50.0 || number >= 70.0 ) {
            JOptionPane.showMessageDialog(null, "Warning!");
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
            txtNotes.setText("The conditions are not ideal to grow snap peas, therefore use worm tea \n"+" to maintain the pH level of the soil greater than 6.");
            Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
        } 
        };            
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        } 
        else if(crop.equalsIgnoreCase("broccoli") && location.equalsIgnoreCase("Boston") && number > 10.0 && number < 70.0 ) {
            int delay = 3000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                txtNotes.setText("Perfect conditions to grow Brocolli and use manure for the best results");
                    Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
      }
  };            Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        } 
        else if(crop.equalsIgnoreCase("brocolli") && location.equalsIgnoreCase("Boston") && number <= 10.0 || number >= 70.0 ) {
            JOptionPane.showMessageDialog(null, "Warning!");
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
            txtNotes.setText("The conditions are not ideal to grow Broccoli, therefore use organic fertilizer to maintain pH level greather than 8.0 and to keep the level of nitrogen at par. ");
            Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
        } 
        };            
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        }
        else if(crop.equalsIgnoreCase("cabbage") && location.equalsIgnoreCase("Boston") && number > 25.0 && number < 80.0 ) {
            int delay = 3000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                txtNotes.setText("Perfect conditions to grow cabbage and use biosolids for the best results");
                    Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
      }
  };            Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        } 
        else if(crop.equalsIgnoreCase("cabbage") && location.equalsIgnoreCase("Boston") && number <= 25.0 || number >= 80.0 ) {
            JOptionPane.showMessageDialog(null, "Warning!");
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
            txtNotes.setText("The conditions are not ideal to grow Cabbage, therefore use manure\n"+" to maintain pH level greather than 5.0 and to keep the alkaline soil. ");
            Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
        } 
        };            
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        }
        else if(crop.equalsIgnoreCase("sweet potato") && location.equalsIgnoreCase("Boston") && number > 30.0 && number < 80.0 ) {
            int delay = 3000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                txtNotes.setText("Perfect conditions to grow Sweet Potato and use manure for the best results");
                    Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
      }
  };            Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        } 
        else if(crop.equalsIgnoreCase("sweet potato") && location.equalsIgnoreCase("Boston") && number <= 30.0 || number >= 80.0 ) {
            JOptionPane.showMessageDialog(null, "Warning!");
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
            txtNotes.setText("The conditions are not ideal to grow Sweet Potato, therefore use organic fertilizer\n"+" to maintain pH level and the biosolids level required for sweet potato. ");
            Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
        } 
        };            
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        }
        else if(crop.equalsIgnoreCase("corn") && location.equalsIgnoreCase("Boston") && number > 35.0 && number < 80.0 ) {
            int delay = 3000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                //JOptionPane.showMessageDialog(null, "Perfect conditions to grow tomatoes and use PestA for the best results");
                txtNotes.setText("Perfect conditions to grow Corn and use manure for the best results");
                    Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
      }
  };            Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        } 
        else if(crop.equalsIgnoreCase("corn") && location.equalsIgnoreCase("Boston") && number <= 35.0 || number >= 80.0 ) {
            JOptionPane.showMessageDialog(null, "Warning!");
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
            txtNotes.setText("The conditions are not ideal to grow Corn, therefore use vermicompost as it has well rotted manure compost. ");
            Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
        } 
        };            
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        }
        else if(crop.equalsIgnoreCase("carrot") && location.equalsIgnoreCase("Boston") && number > 30.0 && number < 70.0 ) {
            int delay = 3000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                //JOptionPane.showMessageDialog(null, "Perfect conditions to grow tomatoes and use PestA for the best results");
                txtNotes.setText("Perfect conditions to grow Carrot and use organic fertilizer for the best results");
                    Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
      }
  };            Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        } 
        else if(crop.equalsIgnoreCase("carrot") && location.equalsIgnoreCase("Boston") && number <= 30.0 || number >= 70.0 ) {
            JOptionPane.showMessageDialog(null, "Warning!");
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
            txtNotes.setText("The conditions are not ideal to grow Carrot, therefore use organic pesticide to cut down the weed growth ");
            Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
        } 
        };            
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        }
        else if(crop.equalsIgnoreCase("lettuce") && location.equalsIgnoreCase("Boston") && number > 20.0 && number < 75.0 ) {
            int delay = 3000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                //JOptionPane.showMessageDialog(null, "Perfect conditions to grow tomatoes and use PestA for the best results");
                txtNotes.setText("Perfect conditions to grow Lettuce and use manure for the best results");
                    Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
      }
  };            Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        } 
        else if(crop.equalsIgnoreCase("lettuce") && location.equalsIgnoreCase("Boston") && number <= 20.0 || number >= 75.0 ) {
            JOptionPane.showMessageDialog(null, "Warning!");
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
            txtNotes.setText("The conditions are not ideal to grow Lettuce, therefore use organic fertilizer\n"+" to maintain pH level greather than 8.0 and to keep the level of nitrogen at par. ");
            Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
        } 
        };            
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        }
        else if(crop.equalsIgnoreCase("cherry tomato") && location.equalsIgnoreCase("Boston") && number > 50.0 && number < 80.0 ) {
            int delay = 3000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                //JOptionPane.showMessageDialog(null, "Perfect conditions to grow tomatoes and use PestA for the best results");
                txtNotes.setText("Perfect conditions to grow Cherry tomatoes and use worm tea for the best results");
                    Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
      }
  };            Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        } 
        else if(crop.equalsIgnoreCase("cherry tomato") && location.equalsIgnoreCase("Boston") && number <= 50.0 || number >= 80.0 ) {
            JOptionPane.showMessageDialog(null, "Warning!");
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
            txtNotes.setText("The conditions are not ideal to grow Cherry Tomatoes, therefore use biosolids\n"+" to maintain the nutririon level and shelf life ");
            Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
        } 
        };            
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        }
        else if(crop.equalsIgnoreCase("kale") && location.equalsIgnoreCase("Boston") && number > 20.0 && number < 70.0 ) {
            int delay = 3000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                //JOptionPane.showMessageDialog(null, "Perfect conditions to grow tomatoes and use PestA for the best results");
                txtNotes.setText("Perfect conditions to grow Kale and use biosolids for the best results");
                    Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
      }
  };            Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        } 
        else if(crop.equalsIgnoreCase("kale") && location.equalsIgnoreCase("Boston") && number <= 20.0 || number >= 70.0 ) {
            JOptionPane.showMessageDialog(null, "Warning!");
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
            txtNotes.setText("The conditions are not ideal to grow Kale, therefore use worm tea\n"+"to maintain pH level greather than 6.0 and to increase the shelf life ");
            Font font = new Font ("",Font.BOLD,20);
            txtNotes.setFont(font);
        } 
        };            
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
        }
    }
    locationTxt.setText("");
    countryTxt.setText("");
    }//GEN-LAST:event_requestWeatherActionPerformed

    private void rmCoboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmCoboBoxActionPerformed

    }//GEN-LAST:event_rmCoboBoxActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
         userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        FarmerWorkAreaJPanel cwjp = (FarmerWorkAreaJPanel) component;
        cwjp.populateRequestRMTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField countryTxt;
    private javax.swing.JTextField currentDayHigh;
    private javax.swing.JTextField currentTempText;
    private javax.swing.JTextField dayAfterHigh;
    private javax.swing.JTextField dayAfterTempText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locationTxt;
    private javax.swing.JTextField nextDayTempText;
    private javax.swing.JButton requestWeather;
    private javax.swing.JComboBox rmCoboBox;
    private javax.swing.JTextField tomDayHigh;
    private javax.swing.JTextArea txtNotes;
    // End of variables declaration//GEN-END:variables

    private void populateCombo() {
        rmCoboBox.addItem("");
        rmCoboBox.addItem("snap peas");
        rmCoboBox.addItem("broccoli");
        rmCoboBox.addItem("cabbage");
        rmCoboBox.addItem("sweet potato");
        rmCoboBox.addItem("corn");
        rmCoboBox.addItem("carrot");
        rmCoboBox.addItem("lettuce");
        rmCoboBox.addItem("cherry tomato");
        rmCoboBox.addItem("kale");
    
                
        
    }
}
