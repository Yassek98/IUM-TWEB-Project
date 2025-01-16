document.addEventListener('DOMContentLoaded', () => {
    fetch('/movies')
        .then(response => response.json())
        .then(data => {
            const moviesList = document.getElementById('movies-list');
            data.forEach(movie => {
                const movieItem = document.createElement('div');
                movieItem.className = 'card mb-3';
                movieItem.innerHTML = `
                    <div class="card-body">
                        <h5 class="card-title">${movie.name}</h5>
                        <p class="card-text">${movie.description}</p>
                        <p class="card-text"><small class="text-muted">Released on ${new Date(movie.date).toLocaleDateString()}</small></p>
                    </div>
                `;
                moviesList.appendChild(movieItem);
            });
        })
        .catch(error => console.error('Error fetching movies:', error));
});
