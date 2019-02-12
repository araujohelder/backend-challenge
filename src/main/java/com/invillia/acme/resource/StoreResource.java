package com.invillia.acme.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.filter.StoreFilter;
import com.invillia.acme.model.Store;
import com.invillia.acme.service.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/store")
@Api(value = "Store")
public class StoreResource {
	
	@Autowired
	private StoreService storeService;
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar uma Store")
	public ResponseEntity<Store>update(@PathVariable Long id, @Validated @RequestBody Store store) {
		Store storeSave = storeService.update(id, store);
		return ResponseEntity.ok().body(storeSave);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Consultar por Id", notes = "/store/10 por exemplo")
	public ResponseEntity<Store> findById(@PathVariable Long id)  {
		Store storeReturned = storeService.findByid(id);
		return storeReturned != null ? ResponseEntity.ok(storeReturned) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	@ApiOperation(value = "Consultar a Store com os parametros informados. ")
	public ResponseEntity<List<Store>> search(@ApiParam(name = "name", value = "String com o nome da Store", required = false ) StoreFilter storeFilter)  {
		List<Store> stores = storeService.search(storeFilter);
		return stores != null ? ResponseEntity.ok(stores) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Criar uma nova Store")
	public ResponseEntity<Store> save(@Valid @RequestBody Store store, HttpServletResponse response) {
		Store storeCreated =  storeService.save(store);
		return ResponseEntity.status(HttpStatus.CREATED).body(storeCreated);
	}
}
