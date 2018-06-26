document.addEventListener("DOMContentLoaded", function() {

    // a prototyp of "replaceAll" method. Made for formatting JSON
    // Tooked from stuckoverflow.com.
    String.prototype.replaceAll = function(search, replacement) {
        var target = this;
        return target.split(search).join(replacement);
    };

    //var quantityArticles;
    var articlesList;

    ////////////////////////////////////////////////////////////////////
    // Search articles contain the searchWord

    $('#search').click(function (e) {

        e.preventDefault();
        var searchWord = $('#searchField').val();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/news/pl/' + searchWord,
            dataType: 'json',
            success: function (jsonObj) {

                // test function
                console.log(jsonObj);

                articlesList = jsonObj.articles;

                // test function
                console.log(articlesList);

                for (var i = 0; i < articlesList.length; i++) {
                    articlesList[i] = JSON.stringify(jsonObj.articles[i]).replaceAll(',', '<br/>');
                }


                // build a table
                $('#tr1').html('<tr><th>Country:</th><td>' + jsonObj.country + '</td></tr>');
                $('#tr2').html('<tr><th>Category:</th><td>all</td></tr>');

                var buildArticlesList = '';
                var counter = 1;

                for (var i = 0; i < articlesList.length; i++) {
                    buildArticlesList += '<tr><th>Article '
                        + counter
                        + ':</th><td>'
                        + articlesList[i]
                        + '</td></tr>';
                    counter++;
                }

                $('#tr3').html(buildArticlesList);
            }
        });

    });


    ////////////////////////////////////////////////////////////////////
    // All articles of a one category

    var categoryArticle = '';

    $('#send1').click(function(e) {

        e.preventDefault();
        categoryArticle = $('#send1').val();
        sendRequestAndDisplayResponse();
    });

    $('#send2').click(function(e) {

        e.preventDefault();
        categoryArticle = $('#send2').val();
        sendRequestAndDisplayResponse();
    });

    $('#send3').click(function(e) {

        e.preventDefault();
        categoryArticle = $('#send3').val();
        sendRequestAndDisplayResponse();
    });

    $('#send4').click(function(e) {

        e.preventDefault();
        categoryArticle = $('#send4').val();
        sendRequestAndDisplayResponse();
    });

    $('#send5').click(function(e) {

        e.preventDefault();
        categoryArticle = $('#send5').val();
        sendRequestAndDisplayResponse();
    });

    $('#send6').click(function(e) {

        e.preventDefault();
        categoryArticle = $('#send6').val();
        sendRequestAndDisplayResponse();
    });

    $('#send7').click(function(e) {

        e.preventDefault();
        categoryArticle = $('#send7').val();
        sendRequestAndDisplayResponse();
    });


    function sendRequestAndDisplayResponse() {

        $.ajax({
            url: 'http://localhost:8080/api/news/pl/' + categoryArticle,
            dataType: 'json',
            success: function (jsonObj) {

                // test function
                //console.log(jsonObj);

                //quantityArticles = jsonObj.totalResults;
                articlesList = jsonObj.articles;

                // test function
                //console.log(articlesList);

                for (var i = 0; i < articlesList.length; i++) {
                    articlesList[i] = JSON.stringify(jsonObj.articles[i]).replaceAll(',', '<br/>');
                }


                // build a table
                $('#tr1').html('<tr><th>Country:</th><td>' + jsonObj.country + '</td></tr>');
                $('#tr2').html('<tr><th>Category:</th><td>' + jsonObj.category + '</td></tr>');

                var buildArticlesList = '';
                var counter = 1;

                for (var i = 0; i < articlesList.length; i++) {
                    buildArticlesList += '<tr><th>Article '
                        + counter
                        + ':</th><td>'
                        + articlesList[i]
                        + '</td></tr>';
                    counter++;
                }

                $('#tr3').html(buildArticlesList);
            }
        });
    }
});