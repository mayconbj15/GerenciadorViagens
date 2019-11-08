package controladores;

import entidades.Viagem;
import gerenciador.dtos.ViagemDto;
import gerenciador.services.ViagemServices;
import gerenciador.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/viagens")
public class GerenciadorViagemController {

    @Autowired
    private ViagemServices viagemService;

    @PostMapping(path = "/new")
    public ResponseEntity<Response<Viagem>> cadastrar(@Valid @RequestBody ViagemDto viagemDto, BindingResult result){
        Response<Viagem> response = new Response<Viagem>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Viagem viagemSalva = this.viagemService.salvar(viagemDto);

        //que isso?
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(viagemDto.getId()).toUri();

        response.setData(viagemSalva);
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Viagem>> listar(){
        List<Viagem> viagens = viagemService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(viagens);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response<Viagem>> buscar(@PathVariable("id") Long id){
        Viagem viagem = viagemService.buscar(id);
        Response<Viagem> response = new Response<>();
        response.setData(viagem);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
