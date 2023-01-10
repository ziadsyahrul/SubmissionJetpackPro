package com.ziadsyahrul.submissionjetpackpro.util

import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.*
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.TvShowDetailResponse

object DataDummy {
    fun getMovie(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                632357,
                "The Unholy",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg",
                "2021-09-14",
                "en",
                7.7,
                false
            ),
            MovieEntity(
                503736,
                "Army of the Dead",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                "2021-05-14",
                "in",
                7.7,
                false
            ),
            MovieEntity(
                823855,
                "I Am All Girls",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "/m6bUeV4mczG3z2YXXr5XDKPsQzv.jpg",
                "2021-05-14",
                "en",
                7.7,
                false
            )
        )
    }

    fun getDetailMov(): MovieEntity {
        return MovieEntity(
            632357,
            "The Unholy",
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
            "/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg",
            "2021-03-31",
            "en",
            7.7,
            false
        )
    }

    fun getTvShow(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                63174,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                "en",
                7.7,
                false
            ),
            TvShowEntity(
                63174,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                "en",
                7.7,
                false
            ),
            TvShowEntity(
                63174,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                "en",
                7.7,
                false
            )
        )
    }

    fun getTvDetail(): TvShowEntity {
        return TvShowEntity(
            63174,
            "Lucifer",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "2016-01-25",
            "en",
            7.7,
            false
        )
    }


    fun getResponseMovie(): List<ResultsMovie> {
        return listOf(
            ResultsMovie(
                overview = "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                originalLanguage = "en",
                originalTitle = "The Unholy",
                title = "The Unholy",
                genreIds = listOf(27),
                posterPath = "/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg",
                releaseDate = "2021-03-31",
                voteAverage = 7.7,
                id = 632357
            ),

            ResultsMovie(
                overview = "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                originalLanguage = "en",
                originalTitle = "Army of the Dead",
                title = "Army of the Dead",
                genreIds = listOf(28, 27, 53),
                posterPath = "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                releaseDate = "2021-05-14",
                voteAverage = 7.7,
                id = 503736
            ),

            ResultsMovie(
                overview = "A special crimes investigator forms an unlikely bond with a serial killer to bring down a global child sex trafficking syndicate.",
                originalLanguage = "en",
                originalTitle = "I Am All Girls",
                title = "I Am All Girls",
                genreIds = listOf(80, 18, 9648, 53),
                posterPath = "/m6bUeV4mczG3z2YXXr5XDKPsQzv.jpg",
                releaseDate = "2021-05-14",
                voteAverage = 7.7,
                id = 823855
            )

        )
    }

    fun getDetailMovResponse(): DetailMovResponse {
        return DetailMovResponse(
            originalLanguage = "en",
            title = "The Unholy",
            genres = listOf(
                GenresItem(
                    name = "Horror",
                    id = 27
                )
            ),
            productionCountries = listOf(
                ProductionCountriesItem(
                    iso31661 = "US",
                    name = "United States of America"
                )
            ),
            id = 632357,
            overview = "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
            originalTitle = "The Unholy",
            posterPath = "/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg",
            spokenLanguages = listOf(
                SpokenLanguagesItem(
                    name = "English",
                    iso6391 = "en",
                    englishName = "English"
                )
            ),
            productionCompanies = listOf(
                ProductionCompaniesItem(
                    logoPath = null,
                    name = "Ghost House Pictures",
                    id = 768,
                    originCountry = "US"
                ),

                ProductionCompaniesItem(
                    logoPath = "/bz6GbCQQXGNE56LTW9dwgksW0Iw.png",
                    name = "Screen Gems",
                    id = 3287,
                    originCountry = "US"
                ),

                ProductionCompaniesItem(
                    logoPath = "/GagSvqWlyPdkFHMfQ3pNq6ix9P.png",
                    name = "Sony Pictures",
                    id = 34,
                    originCountry = "US"
                ),

                ProductionCompaniesItem(
                    logoPath = null,
                    name = "Chapman/Leonard Studio Equipment",
                    id = 6951,
                    originCountry = "_"
                )
            ),
            releaseDate = "2021-03-31"
        )
    }

    fun getResponseTvShow(): List<com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.ResultsTv> {
        return listOf(
            com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.ResultsTv(
                firstAirDate = "2016-01-25",
                overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                originalLanguage = "en",
                genreIds = listOf(80, 10765),
                posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                originalName = "Lucifer",
                name = "Lucifer",
                voteAverage = 7.7,
                id = 63174
            ),

            com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.ResultsTv(
                firstAirDate = "2016-01-25",
                overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                originalLanguage = "en",
                genreIds = listOf(80, 10765),
                posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                originalName = "Lucifer",
                name = "Lucifer",
                voteAverage = 7.7,
                id = 63174
            ),

            com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.ResultsTv(
                firstAirDate = "2016-01-25",
                overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                originalLanguage = "en",
                genreIds = listOf(80, 10765),
                posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                originalName = "Lucifer",
                name = "Lucifer",
                voteAverage = 7.7,
                id = 63174
            ),
        )
    }

    fun getResponseDetailTvShow(): TvShowDetailResponse {
        return TvShowDetailResponse(
            originalLanguage = "en",
            genres = listOf(
                com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.GenresItem(
                    id = 80,
                    name = "Crime"
                ),
                com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.GenresItem(
                    id = 10765,
                    name = "Sci-Fi & Fantasy"
                )
            ),
            id = 63174,
            firstAirDate = "2016-01-25",
            overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            languages = listOf("en"),
            posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            originCountry = listOf("US"),
            spokenLanguages = listOf(
                com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.SpokenLanguagesItem(
                    name = "English",
                    iso6391 = "en",
                    englishName = "English"
                )
            ),
            originalName = "Lucifer",
            name = "Lucifer"

        )
    }

}