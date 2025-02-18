package dns.vitrina.server.controller;

import dns.vitrina.server.service.VitrinaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VitrinaController {
    private final VitrinaService service;


}
