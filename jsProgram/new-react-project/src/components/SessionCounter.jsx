import { useState, useEffect } from 'react';

export default function SessionCounter() {
  const [seconds, setSeconds] = useState(0);
  const [startTime] = useState(Date.now());

  useEffect(() => {
    const interval = setInterval(() => {
      const currentTime = Date.now();
      const elapsedSeconds = Math.floor((currentTime - startTime) / 1000);
      setSeconds(elapsedSeconds);
    }, 1000);

    return () => clearInterval(interval);
  }, [startTime]);

  const formatTime = (totalSeconds) => {
    const hours = Math.floor(totalSeconds / 3600);
    const minutes = Math.floor((totalSeconds % 3600) / 60);
    const secs = totalSeconds % 60;

    if (hours > 0) {
      return `${hours}:${minutes.toString().padStart(2, '0')}:${secs.toString().padStart(2, '0')}`;
    }
    return `${minutes}:${secs.toString().padStart(2, '0')}`;
  };

  return (
    <div >
      <div >
        <div className="mb-8">
          <h1 className="text-3xl font-bold text-gray-800 mb-2">Session Timer</h1>
          <p className="text-gray-600">Time since last refresh</p>
        </div>
        
        <div className="mb-8">
          <div className="text-6xl font-mono font-bold text-indigo-600 mb-4">
            {formatTime(seconds)}
          </div>
          <div className="text-lg text-gray-500">
            {seconds === 1 ? '1 second' : `${seconds} seconds`}
          </div>
        </div>
        
        <div className="space-y-4">
          <div className="flex justify-between text-sm text-gray-500">
            <span>Started:</span>
            <span>{new Date(startTime).toLocaleTimeString()}</span>
          </div>
          <div className="flex justify-between text-sm text-gray-500">
            <span>Current:</span>
            <span>{new Date().toLocaleTimeString()}</span>
          </div>
        </div>
        
        <button 
          onClick={() => window.location.reload()} > Reset Timer
        </button>
      </div>
      
      <div className="mt-8 text-center text-gray-600 max-w-md mx-4">
        <p className="text-sm">
          This counter tracks how long this tab has been open without refreshing. 
          The timer starts when the component loads and continues running until you refresh the page.
        </p>
      </div>
    </div>
  );
}

