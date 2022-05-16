package com.example.metrics

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MoviesController {

    var LOG: Logger = LoggerFactory.getLogger(MoviesController::class.java)

    @GetMapping
    fun getMovies(): ResponseEntity<Unit> {
        LOG.info("Retrieving list of movies")
        return when((0..100).random()) {
            in 0..80 -> ResponseEntity(HttpStatus.OK)
            else -> ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
    }

    @PostMapping
    fun createMovie(@RequestBody movie: Movie): ResponseEntity<Unit> {
        LOG.info("Adding new movie")
        return when((0..100).random()) {
            in 0..97 -> ResponseEntity(HttpStatus.OK)
            else -> ResponseEntity(HttpStatus.CONFLICT)
        }
    }

    @DeleteMapping
    fun deleteMovieById(@RequestParam("id") id: Int): ResponseEntity<Unit> {
        LOG.info("Deleting movie")
        return when((0..100).random()) {
            in 0..90 -> ResponseEntity(HttpStatus.NO_CONTENT)
            else -> ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}
