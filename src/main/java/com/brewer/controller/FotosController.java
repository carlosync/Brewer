package com.brewer.controller;

import com.brewer.dto.FotoDTO;
import com.brewer.storage.FotoStorage;
import com.brewer.storage.FotoStorageRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosController {

    @Autowired
    private FotoStorage fotoStorage;

    @PostMapping
    public DeferredResult<FotoDTO>  upload(@RequestParam("files[]") MultipartFile[] files){
        DeferredResult<FotoDTO> resultado = new DeferredResult<>();

        Thread thread = new Thread(new FotoStorageRunnable(files, resultado, fotoStorage));
        thread.start();

        return resultado;
    }

    @GetMapping("/temp/{nome:.*}")
    public byte[] recuperarFotoTemporaria(@PathVariable String nome){
        return fotoStorage.recuperarFotoTemporaria(nome);
    }

    @DeleteMapping(path = "/temp/{nome:.*}")
    public void apagarFotoTemporaria(@PathVariable String nome){
         fotoStorage.apagarFotoTemporaria(nome);
    }

    @GetMapping("/{nome:.*}")
    public byte[] recuperarFoto(@PathVariable String nome){
        return fotoStorage.recuperarFoto(nome);
    }

}
