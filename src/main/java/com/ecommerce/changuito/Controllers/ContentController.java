
package com.ecommerce.changuito.Controllers;

import com.ecommerce.changuito.Dto.ContentDto;
import com.ecommerce.changuito.Errors.ErrorService;
import com.ecommerce.changuito.Servicies.Impl.ContentServiceImpl;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("content")
public class ContentController {
    
    @Autowired
    private ContentServiceImpl contentService;
    
    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.CREATED).body(contentService.getAll());
    }
    
    @PostMapping("save")
    public ResponseEntity<?> saveContent(@Valid @RequestBody ContentDto contentDto){
        
      ContentDto contentDto1 = contentService.save(contentDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(contentDto1);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateContent(@PathVariable Long id, @Valid @RequestBody ContentDto contentDto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(contentService.update(id, contentDto));
        } catch (ErrorService ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContent(@PathVariable Long id){
        try {
            contentService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(contentService.getById(id));
        } catch (ErrorService ex) {
            return ResponseEntity.status(HttpStatus.CREATED).body(ex.getMessage());
        }
    }
}