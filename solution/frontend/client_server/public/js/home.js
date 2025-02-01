document.addEventListener('DOMContentLoaded', function() {
    const buttons = document.querySelectorAll('.dynamic-content-btn');
    const dynamicContent = document.getElementById('dynamic-content');

    buttons.forEach(button => {
        button.addEventListener('click', function() {
            const content = this.getAttribute('data-content');
            let htmlContent = '';

            switch(content) {
                case 'top-rated':
                    htmlContent = '<h2>Top Rated Movies</h2><p>Here are the highest-rated movies of all time...</p>';
                    break;
                case 'award-winners':
                    htmlContent = '<h2>Award Winners</h2><p>Browse through the Oscar-winning films and performances...</p>';
                    break;
                case 'most-discussed':
                    htmlContent = '<h2>Most Discussed Movies</h2><p>Join the conversation on the most talked-about movies...</p>';
                    break;
                default:
                    htmlContent = '';
            }

            dynamicContent.innerHTML = htmlContent;
        });
    });
});

document.getElementById('search-form').addEventListener('submit', function(event) {
    event.preventDefault();  // Previene il comportamento di default del form
    const query = document.getElementById('search-input').value;
    console.log(query);

    axios.get(`/api/search?query=${encodeURIComponent(query)}`)
        .then(response => {
            const results = response.data;
            const resultsContainer = document.getElementById('search-results');
            resultsContainer.innerHTML = ''; // Pulisce i risultati precedenti

            if (results.length > 0) {
                results.forEach(item => {
                    const resultLink = document.createElement('a');
                    resultLink.classList.add("list-group-item", "list-group-item-action");

                    if (item.type === 'movie') {
                        resultLink.href = `/film/${item.id}`; // Film usa ID
                    } else if (item.type === 'actor') {
                        resultLink.href = `/actor/${item.id}`; // Ora gli attori usano ID, non nome
                    }

                    resultLink.textContent = item.name;
                    resultsContainer.appendChild(resultLink);
                });

                resultsContainer.style.display = 'block'; // Mostra il menu a tendina
            } else {
                resultsContainer.style.display = 'none'; // Nasconde il menu se non ci sono risultati
            }
        })
        .catch(error => {
            console.error('Error fetching search results:', error);
            resultsContainer.style.display = 'none';
        });
});
