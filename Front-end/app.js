document.addEventListener("DOMContentLoaded", function() {

    // a prototyp of "replaceAll" method. Made for formatting JSON
    // I took it from stuckoverflow.com.
    String.prototype.replaceAll = function(search, replacement) {
        var target = this;
        return target.split(search).join(replacement);
    };

    $('#send').one('click', function() {

        $.ajax({
            url: 'http://localhost:8080/api/news/pl/technology',
            dataType: 'json',
            success: function (jsonObj) {

                // test function
                console.log(jsonObj);

                var quantityArticles = jsonObj.totalResults;
                var articlesList = new Array(quantityArticles);

                // test function
                console.log(articlesList);

                for(var i = 0; i < quantityArticles; i++) {
                    articlesList[i] = JSON.stringify(jsonObj.articles[i]).replaceAll(',', '<br/>');
                }

                // start building a table
                $('#tr1').html('<tr><th>Country:</th><td>' + jsonObj.country + '</td></tr>');
                $('#tr2').html('<tr><th>Category:</th><td>' + jsonObj.category + '</td></tr>');

                var buildArticlesList = '';
                var counter = 1;
                for(var i = 0; i < quantityArticles; i++) {
                    buildArticlesList += '<tr><th>Article '
                                            + counter
                                            + ':</th><td>'
                                            + articlesList[i]
                                            + '</td></tr>';
                    counter++;
                }

                $('#tr3').html(buildArticlesList);
                // stop building a table
            }
        });
    });
});