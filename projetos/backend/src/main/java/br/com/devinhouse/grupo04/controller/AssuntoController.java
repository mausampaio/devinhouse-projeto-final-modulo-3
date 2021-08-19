package br.com.devinhouse.grupo04.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinhouse.grupo04.dto.AssuntoDTOInput;
import br.com.devinhouse.grupo04.dto.AssuntoDTOOutput;
import br.com.devinhouse.grupo04.entity.Assunto;
import br.com.devinhouse.grupo04.mapper.AssuntoMapper;
import br.com.devinhouse.grupo04.service.AssuntoService;

@CrossOrigin
@RestController
@Api(tags = "Assuntos", description = "Endpoint de assuntos")
@RequestMapping(value = "v1" + "/assuntos")
public class AssuntoController {
	
	private static final Logger logger = LogManager.getLogger(AssuntoController.class);
	
	@Autowired
	private AssuntoMapper assuntoMapper;
	
	@Autowired
	private AssuntoService service;
	
	@RolesAllowed("user")
	@ApiOperation(value = "", notes = "Endpoint que retorna todos os assuntos.")
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public List<AssuntoDTOOutput> findAll() {
		logger.info("AssuntoController.findAll chamado");
		
		List<Assunto> assuntos = service.findAll();
		
		return assuntoMapper.toDto(assuntos);
	}
	
	@RolesAllowed("user")
	@ApiOperation(value = "", notes = "Endpoint que retorna um assunto pelo Id.")
	@GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public AssuntoDTOOutput find(@PathVariable Long id) {
		logger.info("AssuntoController.find chamado com seguinte id: {}", id);
		
		return assuntoMapper.toDto(service.find(id));
	}
	
	@RolesAllowed("user")
	@ApiOperation(value = "", notes = "Endpoint para criação de um assunto.")
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public AssuntoDTOOutput create(@Valid @RequestBody AssuntoDTOInput assuntoDTO) {
		logger.info("AssuntoController.create chamado");
		
		Assunto assunto = service.create(assuntoMapper.toAssunto(assuntoDTO));
		
		return assuntoMapper.toDto(assunto);
	}
	
	@RolesAllowed("user")
	@ApiOperation(value = "", notes = "Endpoint para edição de um processo.")
	@PutMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody AssuntoDTOInput assuntoDTO) {
		logger.info("AssuntoController.update chamado");
		
		service.update(id, assuntoMapper.toAssunto(assuntoDTO));
	}
	
	@RolesAllowed("user")
	@ApiOperation(value = "", notes = "Endpoint para exclusão de um processo.")
	@DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		logger.info("AssuntoController.delete chamado com seguinte id: {}", id);
		
		service.delete(id);
	}
	
}
 