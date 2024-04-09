package com.example.featureutility;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @PostMapping("/bpm/custom/initialize")
    private String initialize() {
        return "success";
    }

    @Operation(summary = "Get All Employees")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Employee List", content =
            {@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))}),

            @ApiResponse(responseCode = "204", description = "No employee found", content = @Content)})
    @GetMapping("/employees")
    public ResponseEntity<String> read() {
        return ResponseEntity.ok("success");
    }
}