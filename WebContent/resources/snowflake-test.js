// Set empty array to hold created snowflakes
var snowflakes = [];
// Set number of snowflakes  to create
var numberOfSnowflakes = 100;
// Set speed for snowfall in miliseconds
var snowSpeed = 8000;

// Get random percentage for "left" positioning
function getRandomPercent(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min + '%';
}

// Get random int for timing
function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

// Fills array with new snowflakes each with unique name
var count = 0;
while (count <= numberOfSnowflakes) {
    var x = snowflakes[count];
    snowflakes.push('snowflake' + count);
    count++;
}

// Loops through array, creates new div and sets css for each snowflake
for (var i = 0; i < numberOfSnowflakes; i++) {
    var x = snowflakes[i];
    $('#snowflakes').append('<div class="'+x+'" style="float: left; position: absolute; top: 0; left:'+ getRandomPercent(1, 100) +'; width: 8px; height: 8px; border-radius: 5px; background: white;"></div>');
}

// Calls main funtion
setTimeout(snowFall, 1000);

// Main loop function
function snowFall() {
    // Loops through array and finds matching div
    for (var i = 0; i < numberOfSnowflakes; i++) { 
        var t = '.'+snowflakes[i].toString();
        var y = $('#snowflakes').find(t)
        // Each snowflake is timed to fall randomly
        y.delay(getRandomInt(0,10000));
        // Fall to specified distance and fade out 
        y.animate({top: '600px', opacity: '0'}, snowSpeed);
        // Move to top to be repeated while still invisible
        y.animate({top: '1px'}, 1000, function(){
            // Randomly reposition
            $(this).css({left: getRandomPercent(1, 100)});
            // Show again
            $(this).css({opacity: '100'}, 10);
        });
    }
setTimeout(snowFall, 1000); // repeat function
}
