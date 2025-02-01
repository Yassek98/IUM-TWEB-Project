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
