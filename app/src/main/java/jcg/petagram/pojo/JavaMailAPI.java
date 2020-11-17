package jcg.petagram.pojo;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailAPI {

    private String email, nombre, comentario;
    private Context context;

    public JavaMailAPI(String email, String nombre, String comentario, Context context) {
        this.email = email;
        this.nombre = nombre;
        this.comentario = comentario;
        this.context = context;
        enviarComentario();
    }

    private void enviarComentario() {
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Utils.EMAIL,Utils.PASSWORD);
                    }
                });

        String subject = "Mensaje Petagram a " + nombre;

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(Utils.EMAIL);
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            msg.addRecipient(Message.RecipientType.CC, new InternetAddress(email));
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(comentario);
            Transport.send(msg);
            Toast.makeText(context,"Mensaje enviado",Toast.LENGTH_LONG).show();
        } catch (MessagingException mex) {
            Toast.makeText(context,"Envio fallido, error: " + mex,Toast.LENGTH_LONG).show();
        }

    }
}
