$(document).ready(function() {
        $('#fullpage').fullpage({
          sectionsColor: ["#ccffcc", "#ccffff", "#ff9999"],
          anchors: ['home', 'projects', 'aboutme']
        });
        $('.front1a').click(function() {
          $.fn.fullpage.moveSectionDown();
        })

    });
