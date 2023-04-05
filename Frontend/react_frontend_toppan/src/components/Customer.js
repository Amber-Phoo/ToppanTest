import React from 'react';

const Customer = ({customer}) => {
    const { name } = customer;

    return (
        <div className='customer'>
            <div className='customer-name overflow'>{name}</div>
        </div>
    )
}

export default Customer;