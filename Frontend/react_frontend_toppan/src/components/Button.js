import React from 'react';

const Button = () => {
  let country_code = "";

  return (
    <div id='action-btn'>
      <div className='button'>
        <div className='btn-text'>
          Get country : {country_code}
        </div>
      </div>
    </div>
  )
}

export default Button;