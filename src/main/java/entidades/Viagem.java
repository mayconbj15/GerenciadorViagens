package entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "viagem")
@Component
public class Viagem implements Serializable {
    private static final long serialVersionUID = -6888542263201514002L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "local_destino", nullable = false)
    private String localDestino;

    @JsonSerialize(using = DateSerializer.class) //ver essa
    @Column(name = "data_partida", nullable = false)
    private Date dataPartida;

    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "data_retorno", nullable = true)
    private Date dataRetorno;

    @Column(name = "acompanhante", nullable = true)
    private String acompanhante;

    public Viagem(){

    }

    public Viagem(Long id, String localDestino, Date dataPartida, Date dataRetorno, String acompanhante) {
        this.id = id;
        this.localDestino = localDestino;
        this.dataPartida = dataPartida;
        this.dataRetorno = dataRetorno;
        this.acompanhante = acompanhante;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getDataPartida(){
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida){
        this.dataPartida = dataPartida;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getDataRetorno(){
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno){
        this.dataRetorno = dataRetorno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public String getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(String acompanhante) {
        this.acompanhante = acompanhante;
    }
}
